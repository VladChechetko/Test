package ru.volnenko.se.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.volnenko.se.api.service.CommandProvider;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.error.CommandAbsentException;
import ru.volnenko.se.service.TerminalService;

/**
 * @author Denis Volnenko
 */
@Component
public class Bootstrap implements CommandProvider {

	@Autowired
    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    @Autowired
    public TerminalService terminalService;

    public void start() {
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String command = "";
        while (!"exit".equals(command)) {
            command = terminalService.nextLine();
            try {
				execute(command);
            } catch (CommandAbsentException cae) {
            	System.out.println("COMMAND NOT FOUND");
            } catch (NumberFormatException nfe) {
            	System.out.println("ERROR. INCORRECT INPUT.");
			} catch (Exception e) {
				System.out.println("SYSTEM ERROR!!!");
				e.printStackTrace();
			}
        }
    }

    private void execute(final String command) throws Exception {
        if (command == null || command.isEmpty()) return;
        final AbstractCommand abstractCommand = commands.get(command);
        if (abstractCommand == null) throw new CommandAbsentException();
        abstractCommand.execute();
    }

    public List<AbstractCommand> getCommands() {
        return new ArrayList<>(commands.values());
    }

}
