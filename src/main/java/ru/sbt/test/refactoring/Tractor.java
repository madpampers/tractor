package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.behaviours.ClockwiseDirectionTurning;
import ru.sbt.test.refactoring.behaviours.ForwardMovement;
import ru.sbt.test.refactoring.behaviours.interfaces.ForwardMovable;
import ru.sbt.test.refactoring.behaviours.interfaces.ClockwiseTurnable;

public class Tractor implements ForwardMovable, ClockwiseTurnable {

    private final ForwardMovement movementBehaviour;
    private final ClockwiseDirectionTurning turnBehaviour;

    public Tractor(MovementArea area) {
        this.movementBehaviour = new ForwardMovement(area, Orientation.NORTH);
        this.turnBehaviour = new ClockwiseDirectionTurning(Orientation.NORTH);
    }

    public Orientation getOrientation() {
        return turnBehaviour.getOrientation();
    }

    public Position getPosition() {
        return movementBehaviour.getPosition();
    }

    @Override
    public void moveForward() {
        movementBehaviour.moveForward();
    }

    @Override
    public void turnRight() {
        turnBehaviour.turnRight();
        movementBehaviour.setOrientation(turnBehaviour.getOrientation());
    }
}

