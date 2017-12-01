package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.behaviours.ForwardMovement;
import ru.sbt.test.refactoring.behaviours.interfaces.Navigator;

public class Train implements Navigator {

    private ForwardMovement forwardMovement;

    public Train() {
        this.forwardMovement = new ForwardMovement(new MovementArea(100, 2), this);
    }

    @Override
    public Orientation getOrientation() {
        return Orientation.NORTH;
    }

    public void moveForward() {
        forwardMovement.moveForward();
    }
}
