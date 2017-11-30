package ru.sbt.test.refactoring.commands;
import ru.sbt.test.refactoring.AbstractFigure;

public class TurnClockwiseCommand implements Command{
    private AbstractFigure figure;

    TurnClockwiseCommand(AbstractFigure figure) {
        this.figure = figure;
    }

    public void execute() {
        figure.turnClockwise();
    }
}
