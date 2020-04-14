package ru.volnenko.se.command.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.service.TaskService;

/**
 * @author Denis Volnenko
 */
@Component("task-clear")
public class TaskClearCommand extends AbstractCommand {

	@Autowired
	private TaskService taskService;
	
    @Override
    public String description() {
        return "Remove all tasks.";
    }

    @Override
    public String command() {
        return "task-clear";
    }

    @Override
    public void execute() {
    	taskService.clear();
        System.out.println("[ALL TASK REMOVED]");
    }

}
