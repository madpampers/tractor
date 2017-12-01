package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.commands.Command;

public class Skynet {
    public void controlRobots (Command command) {
        command.execute();
    }
}
