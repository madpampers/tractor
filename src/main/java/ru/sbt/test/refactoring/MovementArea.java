package ru.sbt.test.refactoring;

public class MovementArea {
    private final int length;
    private final int height;

    MovementArea(int length, int height) {
        this.length = length;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }
}
