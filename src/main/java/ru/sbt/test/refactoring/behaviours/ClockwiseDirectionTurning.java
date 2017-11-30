package ru.sbt.test.refactoring.behaviours;

import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.behaviours.interfaces.ClockwiseTurnable;

public class ClockwiseDirectionTurning implements ClockwiseTurnable {
    protected Orientation orientation;

    public ClockwiseDirectionTurning(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void turnRight() {
        orientation = orientation.getRight();
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
