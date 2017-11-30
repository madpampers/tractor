package ru.sbt.test.refactoring;

public class Car extends AbstractFigure {
    private int speed = 2;

    public void moveForwards() {
        int newX = getPositionX() + orientation.getXDirection() * speed;
        int newY = getPositionY() + orientation.getYDirection() * speed;
        changePosition(newX, newY);
    }

    public void turnClockwise() {
        for (int i = 0; i < speed; i++) {
            orientation = orientation.turnRight();
        }
    }
}
