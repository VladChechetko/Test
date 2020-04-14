package ru.volnenko.se.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.volnenko.se.api.service.CommandProvider;
import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
@Component
public class TerminalService {

    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    private CommandProvider commandProvider;

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

    public List<AbstractCommand> getCommands() {
        return commandProvider.getCommands();
    }
}
