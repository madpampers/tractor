package ru.sbt.test.refactoring;

public class Train extends AbstractFigure {
    private int speed = 2;

    public void moveForwards() {
        int newX = getPositionX() + orientation.getXDirection() * speed;
        int newY = getPositionY() + orientation.getYDirection() * speed;
        changePosition(newX, newY);
    }

    public void turnClockwise() {
    }
}
