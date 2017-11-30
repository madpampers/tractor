package ru.sbt.test.refactoring.commands;

import ru.sbt.test.refactoring.behaviours.interfaces.ForwardMovable;

public class ForwardMoveCommand implements Command {
    private final ForwardMovable forwardMovable;
    private final int distance;

    public ForwardMoveCommand(ForwardMovable forwardMovable) {
        this(forwardMovable, 1);
    }

    public ForwardMoveCommand(ForwardMovable forwardMovable, int distance) {
        this.forwardMovable = forwardMovable;
        this.distance = distance;
    }


    @Override
    public void execute() {
        for (int i = 0; i < distance; i++) {
            forwardMovable.moveForward();
        }
    }
}
