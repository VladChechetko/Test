package ru.volnenko.se.command.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.service.ProjectService;
import ru.volnenko.se.service.TerminalService;

/**
 * @author Denis Volnenko
 */
@Component("project-remove")
public class ProjectRemoveCommand extends AbstractCommand {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TerminalService terminalService;
	
    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "Remove selected project.";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT REMOVE]");
        System.out.println("ENTER PROJECT ID:");
        final String id = terminalService.nextLine();
    	projectService.removeProjectById(id);
    }

}
