package ru.volnenko.se.command.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.service.TaskService;
import ru.volnenko.se.service.TerminalService;

/**
 * @author Denis Volnenko
 */
@Component("task-create")
public class TaskCreateCommand extends AbstractCommand {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TerminalService terminalService;

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "Create new task.";
    }

    @Override
    public void execute() {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = terminalService.nextLine();
        System.out.println("ENTER PROJECT ID:");
        final String projectId = terminalService.nextLine();
        taskService.createTaskByProject(projectId, name);
        System.out.println("[OK]");
        System.out.println();
    }

}
