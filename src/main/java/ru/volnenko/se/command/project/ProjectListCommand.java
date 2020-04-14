package ru.volnenko.se.command.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.entity.Project;
import ru.volnenko.se.service.ProjectService;

/**
 * @author Denis Volnenko
 */
@Component("project-list")
public class ProjectListCommand extends AbstractCommand {

	@Autowired
	private ProjectService projectService;

    @Override
    public String command() {
        return "project-list";
    }

    @Override
    public String description() {
        return "Show all projects.";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT LIST]");
        for (Project project: projectService.getListProject()) {
            System.out.println(project.getId() + ". " + project.getName());
        }
        System.out.println();
    }

}
