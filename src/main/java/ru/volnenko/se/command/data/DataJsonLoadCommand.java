package ru.volnenko.se.command.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.volnenko.se.api.service.IProjectService;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.entity.Project;

/**
 * @author Denis Volnenko
 */
@Component("data-json-load")
public final class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-load";
    }

    @Override
    public String description() {
        return "Load projects from JSON.";
    }

    @Override
    public void execute() {
    	File file = new File("projects.json");
    	if (!file.exists()) {
    		System.out.println("[ERROR]");
    		System.out.println("File not found");
    		return;
    	}
    	
    	try {
    		ObjectMapper mapper = new ObjectMapper();
    		List<Project> projects = mapper.readValue(file, new TypeReference<List<Project>>(){});
    		IProjectService projectService = serviceLocator.getProjectService();
    		projectService.clear();
    		projectService.load(projects);
		} catch (Exception e) {
			System.out.println("[ERROR]");
			e.printStackTrace();
			return;
		}
    	System.out.println("[PROJECTS LOADED]");
    	System.out.println("File: "+file.getAbsolutePath());
    	System.out.println();
    }

}
