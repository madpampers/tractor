package ru.sbt.test.refactoring.behaviours;

import ru.sbt.test.refactoring.MovementArea;
import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.behaviours.interfaces.FourDirectionsMovable;

public class FourDirectionsMovement extends ForwardMovement implements FourDirectionsMovable {
    public FourDirectionsMovement(MovementArea area, Orientation orientation) {
        super(area, orientation);
    }

    @Override
    public void moveBack() {
        changePosition(orientation.getBack());
    }

    @Override
    public void moveRight() {
        changePosition(orientation.getRight());
    }

    @Override
    public void moveLeft() {
        changePosition(orientation.getLeft());
    }
}
