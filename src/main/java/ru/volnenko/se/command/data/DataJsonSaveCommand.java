package ru.volnenko.se.command.data;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.entity.Project;

/**
 * @author Denis Volnenko
 */
@Component("data-json-save")
public final class DataJsonSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-save";
    }

    @Override
    public String description() {
        return "Save projects to JSON.";
    }

    @Override
    public void execute() {
    	List<Project> projects = serviceLocator.getProjectService().getListProject();
    	File file = new File("projects.json");
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			mapper.writeValue(file, projects);
		} catch (Exception e) {
			System.out.println("[ERROR]");
			e.printStackTrace();
			return;
		}
    	System.out.println("[PROJECTS SAVED]");
    	System.out.println("File: "+file.getAbsolutePath());
    	System.out.println();
    }

}
