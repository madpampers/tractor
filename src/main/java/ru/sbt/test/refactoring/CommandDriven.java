package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.commands.Command;

public interface CommandDriven {
    void move(Command command);
}
