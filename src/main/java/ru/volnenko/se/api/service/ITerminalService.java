package ru.volnenko.se.api.service;

import ru.volnenko.se.command.AbstractCommand;

import java.util.List;

/**
 * @author Denis Volnenko
 */
public interface ITerminalService {

    String nextLine();

    Integer nextInteger();

    List<AbstractCommand> getCommands();

}
