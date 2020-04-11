package ru.volnenko.se.controller;

import ru.volnenko.se.api.repository.IProjectRepository;
import ru.volnenko.se.api.repository.ITaskRepository;
import ru.volnenko.se.api.service.*;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.error.CommandAbsentException;
import ru.volnenko.se.error.CommandCorruptException;
import ru.volnenko.se.repository.ProjectRepository;
import ru.volnenko.se.repository.TaskRepository;
import ru.volnenko.se.service.ProjectService;
import ru.volnenko.se.service.TaskService;
import ru.volnenko.se.service.TerminalService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Denis Volnenko
 */
@Component
public final class Bootstrap implements ServiceLocator, CommandProvider {

	@Autowired
    private ITaskRepository taskRepository;

	@Autowired
    private IProjectRepository projectRepository;

	@Autowired
    private IProjectService projectService;

	@Autowired
    private ITaskService taskService;

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    @Autowired
    public ITerminalService terminalService;

    public ITaskRepository getTaskRepository() {
        return taskRepository;
    }

    public IProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public IProjectService getProjectService() {
        return projectService;
    }

    public ITaskService getTaskService() {
        return taskService;
    }

    public ITerminalService getTerminalService() {
        return terminalService;
    }

    public void registry(final AbstractCommand command) {
        final String cliCommand = command.command();
        final String cliDescription = command.description();
        if (cliCommand == null || cliCommand.isEmpty()) throw new CommandCorruptException();
        if (cliDescription == null || cliDescription.isEmpty()) throw new CommandCorruptException();
        command.setServiceLocator(this);
        commands.put(cliCommand, command);
    }

    public void registry(final Class... classes) throws InstantiationException, IllegalAccessException {
        for (final Class clazz : classes) registry(clazz);
    }

    public void registry(final Class clazz) throws IllegalAccessException, InstantiationException {
        if (!AbstractCommand.class.isAssignableFrom(clazz)) return;
        final Object command = clazz.newInstance();
        final AbstractCommand abstractCommand = (AbstractCommand) command;
        registry(abstractCommand);
    }

    public void init(final Class... classes) throws Exception {
        if (classes == null || classes.length == 0) throw new CommandAbsentException();
        registry(classes);
        start();
    }

    private void start() throws Exception {
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String command = "";
        while (!"exit".equals(command)) {
            command = terminalService.nextLine();
            execute(command);
        }
    }

    private void execute(final String command) throws Exception {
        if (command == null || command.isEmpty()) return;
        final AbstractCommand abstractCommand = commands.get(command);
        if (abstractCommand == null) return;
        abstractCommand.execute();
    }

    public List<AbstractCommand> getCommands() {
        return new ArrayList<>(commands.values());
    }

}
