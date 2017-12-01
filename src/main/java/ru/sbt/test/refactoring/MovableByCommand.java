package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.commands.Command;

public interface MovableByCommand {
    void move(Command command);
}
