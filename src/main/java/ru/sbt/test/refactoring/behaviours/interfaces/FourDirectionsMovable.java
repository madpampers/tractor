package ru.sbt.test.refactoring.behaviours.interfaces;

public interface FourDirectionsMovable extends ForwardMovable {
    void moveBack();

    void moveRight();

    void moveLeft();
}
