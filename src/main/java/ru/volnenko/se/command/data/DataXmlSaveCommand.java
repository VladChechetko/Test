package ru.volnenko.se.command.data;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.entity.Project;

/**
 * @author Denis Volnenko
 */
@Component("data-xml-save")
public final class DataXmlSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-save";
    }

    @Override
    public String description() {
        return "Save projects to XML.";
    }

    @Override
    public void execute() {
    	List<Project> projects = serviceLocator.getProjectService().getListProject();
    	File file = new File("projects.xml");
    	XmlMapper mapper = new XmlMapper();
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
