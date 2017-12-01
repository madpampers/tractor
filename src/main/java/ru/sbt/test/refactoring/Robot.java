package ru.sbt.test.refactoring;


import ru.sbt.test.refactoring.behaviours.FourDirectionsMovement;
import ru.sbt.test.refactoring.behaviours.TwoDirectionsTurning;
import ru.sbt.test.refactoring.behaviours.interfaces.FourDirectionsMovable;
import ru.sbt.test.refactoring.behaviours.interfaces.ClockwiseTurnable;
import ru.sbt.test.refactoring.behaviours.interfaces.CounterClockwiseTurnable;

public class Robot implements FourDirectionsMovable, ClockwiseTurnable, CounterClockwiseTurnable {

    private final FourDirectionsMovement movementBehavior;
    private final TwoDirectionsTurning turningBehavior;

    public Robot(MovementArea area) {
        this.turningBehavior = new TwoDirectionsTurning(Orientation.NORTH);
        this.movementBehavior = new FourDirectionsMovement(area, turningBehavior);
    }

    public Orientation getOrientation() {
        return turningBehavior.getOrientation();
    }

    public Position getPosition() {
        return movementBehavior.getPosition();
    }

    @Override
    public void moveBack() {
        movementBehavior.moveBack();
    }

    @Override
    public void moveRight() {
        movementBehavior.moveRight();
    }

    @Override
    public void moveLeft() {
        movementBehavior.moveLeft();
    }

    @Override
    public void moveForward() {
        movementBehavior.moveForward();
    }

    @Override
    public void turnRight() {
        turningBehavior.turnRight();
    }

    @Override
    public void turnLeft() {
        turningBehavior.turnLeft();
    }
}
