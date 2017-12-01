package ru.sbt.test.refactoring.behaviours;

import ru.sbt.test.refactoring.MovementArea;
import ru.sbt.test.refactoring.behaviours.interfaces.FourDirectionsMovable;
import ru.sbt.test.refactoring.behaviours.interfaces.Navigator;

public class FourDirectionsMovement extends ForwardMovement implements FourDirectionsMovable {
    public FourDirectionsMovement(MovementArea area, Navigator navigator) {
        super(area, navigator);
    }

    @Override
    public void moveBack() {
        changePosition(navigator.getOrientation().getBack());
    }

    @Override
    public void moveRight() {
        changePosition(navigator.getOrientation().getRight());
    }

    @Override
    public void moveLeft() {
        changePosition(navigator.getOrientation().getLeft());
    }
}
