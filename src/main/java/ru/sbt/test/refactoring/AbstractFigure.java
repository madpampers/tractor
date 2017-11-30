package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.commands.Command;
import ru.sbt.test.refactoring.commands.CommandFactory;

import static ru.sbt.test.refactoring.Orientation.NORTH;

public abstract class AbstractFigure {
    private Position position;
    protected Orientation orientation;
    private final Field field;

    public AbstractFigure() {
        this.position = new Position(0,0);
        this.orientation = NORTH;
        this.field = new Field(5,5);
    }

    public void move(String command) {
            Command move = CommandFactory.createCommand(command, this);
            move.execute();
    }

    public abstract void moveForwards();

    public abstract void turnClockwise();

    public int getPositionX() {
        return position.x;
    }

    public int getPositionY() {
        return position.y;
    }

    Orientation getOrientation() {
        return orientation;
    }

    void changePosition(int x, int y) {
        position.x = x;
        position.y = y;
        checkPosition();
    }

    private void checkPosition() {
        if (position.x > field.getLength() || position.y > field.getHeight()) {
            throw new TractorInDitchException();
        }
    }

    private static class Position {
        private int x;
        private int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
