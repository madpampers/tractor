package ru.sbt.test.refactoring.commands;

import ru.sbt.test.refactoring.AbstractFigure;

public class ForwardMoveCommand implements Command{
    private AbstractFigure figure;

    ForwardMoveCommand(AbstractFigure figure) {
        this.figure = figure;
    }

    public void execute() {
        figure.moveForwards();
    }
}
