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

	@Autowired
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

    public void start() throws Exception {
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
