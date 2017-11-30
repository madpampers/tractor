package ru.sbt.test.refactoring;

public enum Orientation {

    NORTH(0, 1) {
        public Orientation turnRight() {
            return EAST;
        }

        public Orientation turnLeft() {
            return WEST;
        }
    },

    EAST(1, 0) {
        public Orientation turnRight() {
            return SOUTH;
        }

        public Orientation turnLeft() {
            return NORTH;
        }
    },

    WEST(-1, 0) {
        public Orientation turnRight() {
            return NORTH;
        }

        public Orientation turnLeft() {
            return SOUTH;
        }
    },

    SOUTH(0, -1) {
        public Orientation turnRight() {
            return WEST;
        }

        public Orientation turnLeft() {
            return EAST;
        }
    };

    private final int xDirection;
    private final int yDirection;

    Orientation(int xDirection, int yDirection) {
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public int getXDirection() {
        return xDirection;
    }

    public int getYDirection() {
        return yDirection;
    }

    public abstract Orientation turnRight();

    public abstract Orientation turnLeft();
}
