package ru.volnenko.se.command.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.service.ProjectService;
import ru.volnenko.se.service.TerminalService;

/**
 * @author Denis Volnenko
 */
@Component("project-create")
public class ProjectCreateCommand extends AbstractCommand {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TerminalService terminalService;
	
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
        final String name = terminalService.nextLine();
        projectService.createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
