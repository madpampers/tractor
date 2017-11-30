package ru.sbt.test.refactoring.commands;

import ru.sbt.test.refactoring.behaviours.interfaces.FourDirectionsMovable;

public class LeftMoveCommand implements Command {
    private final FourDirectionsMovable movable;
    private final int distance;

    public LeftMoveCommand(FourDirectionsMovable movable) {
        this(movable, 1);
    }

    public LeftMoveCommand(FourDirectionsMovable movable, int distance) {
        this.movable = movable;
        this.distance = distance;
    }


    @Override
    public void execute() {
        for (int i = 0; i < distance; i++) {
            movable.moveLeft();
        }
    }
}
