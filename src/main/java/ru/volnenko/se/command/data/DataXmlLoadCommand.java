package ru.volnenko.se.command.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ru.volnenko.se.api.service.IProjectService;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.entity.Project;

/**
 * @author Denis Volnenko
 */
@Component("data-xml-load")
public final class DataXmlLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-load";
    }

    @Override
    public String description() {
        return "Load projects from XML.";
    }

    @Override
    public void execute() {
    	File file = new File("projects.xml");
    	if (!file.exists()) {
    		System.out.println("[ERROR]");
    		System.out.println("File not found");
    		return;
    	}
    	
    	try {
    		XmlMapper mapper = new XmlMapper();
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
