package ru.volnenko.se.command.project;

import org.springframework.stereotype.Component;

import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
@Component("project-create")
public final class ProjectCreateCommand extends AbstractCommand {

    @Override
    public String description() {
        return "Create new project.";
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        final String name = serviceLocator.getTerminalService().nextLine();
        serviceLocator.getProjectService().createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
