package ru.sbt.test.refactoring.commands;

public class IncorrectCommand implements Command {
    public void execute() {
        System.out.println("No such command");
    }
}
