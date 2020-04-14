package ru.volnenko.se.command.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.service.ProjectService;

/**
 * @author Denis Volnenko
 */
@Component("project-clear")
public class ProjectClearCommand extends AbstractCommand {

	@Autowired
	private ProjectService projectService;
	
    @Override
    public String command() {
        return "project-clear";
    }

    @Override
    public String description() {
        return "Remove all projects.";
    }

    @Override
    public void execute() {
        projectService.clear();
        System.out.println("[ALL PROJECTS REMOVED]");
    }

}
