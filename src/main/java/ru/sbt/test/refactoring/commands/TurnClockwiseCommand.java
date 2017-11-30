package ru.sbt.test.refactoring.commands;

import ru.sbt.test.refactoring.behaviours.interfaces.ClockwiseTurnable;

public class TurnClockwiseCommand implements Command {
    private final int count;
    private final ClockwiseTurnable clockwiseTurnable;

    public TurnClockwiseCommand(ClockwiseTurnable clockwiseTurnable) {
        this(clockwiseTurnable, 1);
    }

    public TurnClockwiseCommand(ClockwiseTurnable clockwiseTurnable, int count) {
        this.clockwiseTurnable = clockwiseTurnable;
        this.count = count;
    }

    public void execute() {
        for (int i = 0; i < count; i++) {
            clockwiseTurnable.turnRight();
        }
    }
}
