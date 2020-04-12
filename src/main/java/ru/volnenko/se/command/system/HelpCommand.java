package ru.volnenko.se.command.system;

import org.springframework.stereotype.Component;

import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
@Component("help")
public final class HelpCommand extends AbstractCommand {

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "Show all commands.";
    }

    @Override
    public void execute() {
        for (final AbstractCommand command: serviceLocator.getTerminalService().getCommands()) {
            System.out.println(command.command()+ ": " + command.description());
        }
    }

}
