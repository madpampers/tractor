package ru.sbt.test.refactoring.commands;

import java.util.List;

public class ForwardThenBackwardMacroCommand implements Command{
    private List<Command> commands;

    public ForwardThenBackwardMacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
