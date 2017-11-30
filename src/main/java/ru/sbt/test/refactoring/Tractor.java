package ru.sbt.test.refactoring;

public class Tractor extends AbstractFigure {

    @Override
    public void moveForwards() {
        int newX = getPositionX() + orientation.getXDirection();
        int newY = getPositionY() + orientation.getYDirection();
        changePosition(newX, newY);
    }


    @Override
    public void turnClockwise() {
        orientation = orientation.turnRight();
    }
}
