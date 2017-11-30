package ru.sbt.test.refactoring.behaviours;

import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.behaviours.interfaces.CounterClockwiseTurnable;

public class TwoDirectionsTurning extends ClockwiseDirectionTurning implements CounterClockwiseTurnable {

    public TwoDirectionsTurning(Orientation orientation) {
        super(orientation);
    }

    @Override
    public void turnLeft() {
        orientation = orientation.getLeft();
    }
}
