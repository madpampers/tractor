package ru.sbt.test.refactoring.behaviours;

import ru.sbt.test.refactoring.MovementArea;
import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.Position;
import ru.sbt.test.refactoring.behaviours.interfaces.ForwardMovable;
import ru.sbt.test.refactoring.behaviours.interfaces.Navigator;
import ru.sbt.test.refactoring.exceptions.InDitchException;

public class ForwardMovement implements ForwardMovable {
    private Position position;
    protected Navigator navigator;
    private final MovementArea area;

    public ForwardMovement(MovementArea area, Navigator navigator) {
        this.position = new Position(0, 0);
        this.navigator = navigator;
        this.area = area;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void moveForward() {
        changePosition(navigator.getOrientation());
    }

    protected boolean isPositionIncorrect() {
        return position.getX() > area.getLength() || position.getY() > area.getHeight();
    }

    protected void changePosition(Orientation orientation) {
        position = new Position(orientation.getXDirection() + position.getX(),
                                orientation.getYDirection() + position.getY());

        if (isPositionIncorrect()) {
            throw new InDitchException();
        }
    }
}
