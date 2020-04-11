package ru.volnenko.se;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.volnenko.se.command.project.ProjectClearCommand;
import ru.volnenko.se.command.project.ProjectCreateCommand;
import ru.volnenko.se.command.project.ProjectListCommand;
import ru.volnenko.se.command.project.ProjectRemoveCommand;
import ru.volnenko.se.command.system.HelpCommand;
import ru.volnenko.se.command.task.TaskClearCommand;
import ru.volnenko.se.command.task.TaskCreateCommand;
import ru.volnenko.se.command.task.TaskListCommand;
import ru.volnenko.se.command.task.TaskRemoveCommand;
import ru.volnenko.se.controller.Bootstrap;

@Configuration
@ComponentScan(basePackages = "ru.volnenko")
public class App {

    private static final Class[] CLASSES = {
            HelpCommand.class,
            ProjectClearCommand.class, ProjectCreateCommand.class,
            ProjectListCommand.class, ProjectRemoveCommand.class,
            TaskClearCommand.class, TaskCreateCommand.class,
            TaskListCommand.class, TaskRemoveCommand.class,
    };

    public static void main(String[] args) throws Exception {
    	ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    	
        final Bootstrap bootstrap = context.getBean(Bootstrap.class);
        bootstrap.init(CLASSES);
        
    }

}
