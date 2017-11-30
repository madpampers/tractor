package ru.sbt.test.refactoring;

public enum Orientation {

    NORTH(0, 1) {
        @Override
        public Orientation getRight() {
            return EAST;
        }

        @Override
        public Orientation getLeft() {
            return WEST;
        }

        @Override
        public Orientation getBack() {
            return SOUTH;
        }
    },

    EAST(1, 0) {
        @Override
        public Orientation getRight() {
            return SOUTH;
        }

        @Override
        public Orientation getLeft() {
            return NORTH;
        }

        @Override
        public Orientation getBack() {
            return WEST;
        }


    },

    WEST(-1, 0) {
        @Override
        public Orientation getRight() {
            return NORTH;
        }

        @Override
        public Orientation getLeft() {
            return SOUTH;
        }

        @Override
        public Orientation getBack() {
            return EAST;
        }
    },

    SOUTH(0, -1) {
        @Override
        public Orientation getRight() {
            return WEST;
        }

        @Override
        public Orientation getLeft() {
            return EAST;
        }

        @Override
        public Orientation getBack() {
            return NORTH;
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

    public abstract Orientation getRight();

    public abstract Orientation getLeft();

    public abstract Orientation getBack();
}

