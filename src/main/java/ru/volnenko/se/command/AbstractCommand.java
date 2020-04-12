package ru.volnenko.se.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.volnenko.se.api.service.ServiceLocator;
import ru.volnenko.se.controller.Bootstrap;

/**
 * @author Denis Volnenko
 */
@Component
public abstract class AbstractCommand {

    protected ServiceLocator serviceLocator;

    @Autowired
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public abstract String command();

    public abstract String description();

    public abstract void execute() throws Exception;

}
