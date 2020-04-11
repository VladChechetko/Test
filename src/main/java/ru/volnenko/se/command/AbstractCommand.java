package ru.volnenko.se.command;

import ru.volnenko.se.api.service.ServiceLocator;
import ru.volnenko.se.controller.Bootstrap;

/**
 * @author Denis Volnenko
 */
public abstract class AbstractCommand {

    protected ServiceLocator serviceLocator;

    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public abstract String command();

    public abstract String description();

    public abstract void execute() throws Exception;

}
