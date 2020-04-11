package ru.volnenko.se.service;

import ru.volnenko.se.api.service.CommandProvider;
import ru.volnenko.se.api.service.ITerminalService;
import ru.volnenko.se.command.AbstractCommand;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

/**
 * @author Denis Volnenko
 */
@Component
public final class TerminalService implements ITerminalService {

    private final Scanner scanner = new Scanner(System.in);

    private final CommandProvider commandProvider;

    public TerminalService(CommandProvider commandProvider) {
        this.commandProvider = commandProvider;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public Integer nextInteger() {
        final String value = nextLine();
        if (value == null || value.isEmpty()) return null;
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<AbstractCommand> getCommands() {
        return commandProvider.getCommands();
    }
}
