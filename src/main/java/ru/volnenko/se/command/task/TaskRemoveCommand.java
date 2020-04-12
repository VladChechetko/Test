package ru.volnenko.se.command.task;

import org.springframework.stereotype.Component;

import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
@Component("task-remove")
public final class TaskRemoveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "Remove selected task.";
    }

    @Override
    public void execute() {
        System.out.println("[REMOVING TASK]");
        System.out.println("Enter task order index:");
        final Integer orderIndex = serviceLocator.getTerminalService().nextInteger();
        if (orderIndex == null) {
            System.out.println("Error! Incorrect order index...");
            System.out.println();
            return;
        }
        System.out.println("[OK]");
    }

}
