package ru.sbt.test.refactoring.behaviours;

import ru.sbt.test.refactoring.MovementArea;
import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.Position;
import ru.sbt.test.refactoring.behaviours.interfaces.ForwardMovable;
import ru.sbt.test.refactoring.exceptions.InDitchException;

public class ForwardMovement implements ForwardMovable {
    private Position position;
    protected Orientation orientation;
    private final MovementArea area;

    public ForwardMovement(MovementArea area, Orientation orientation) {
        this.position = new Position(0, 0);
        this.orientation = orientation;
        this.area = area;
    }

    public Position getPosition() {
        return position;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void moveForward() {
        changePosition(orientation);
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
