package ru.sbt.test.refactoring.commands;

import ru.sbt.test.refactoring.behaviours.interfaces.FourDirectionsMovable;

public class BackwardMoveCommand implements Command {
    private final FourDirectionsMovable movable;
    private final int distance;

    public BackwardMoveCommand(FourDirectionsMovable movable) {
        this(movable, 1);
    }

    public BackwardMoveCommand(FourDirectionsMovable movable, int distance) {
        this.movable = movable;
        this.distance = distance;
    }

    @Override
    public void execute() {
        for (int i = 0; i < distance; i++) {
            movable.moveBack();
        }
    }
}

