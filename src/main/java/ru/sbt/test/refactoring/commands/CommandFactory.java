package ru.sbt.test.refactoring.commands;

import ru.sbt.test.refactoring.AbstractFigure;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {

    public static Command createCommand(String command, AbstractFigure figure) {
        if (command.equals("F")) {
            return new ForwardMoveCommand(figure);
        }

        if (command.equals("T")) {
            return new TurnClockwiseCommand(figure);
        }

        if (command.equals("M")) {
            List<Command> commands = new ArrayList<Command>();
            commands.add(new ForwardMoveCommand(figure));
            commands.add(new TurnClockwiseCommand(figure));
            commands.add(new TurnClockwiseCommand(figure));
            commands.add(new ForwardMoveCommand(figure));
            return new ForwardThenBackwardMacroCommand(commands);
        }

        else return new IncorrectCommand();
    }
}
