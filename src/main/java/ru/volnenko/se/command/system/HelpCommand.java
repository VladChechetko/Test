package ru.volnenko.se.command.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.service.TerminalService;

/**
 * @author Denis Volnenko
 */
@Component("help")
public class HelpCommand extends AbstractCommand {

	@Autowired
	private TerminalService terminalService;

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
        for (final AbstractCommand command: terminalService.getCommands()) {
            System.out.println(command.command()+ ": " + command.description());
        }
    }

}
