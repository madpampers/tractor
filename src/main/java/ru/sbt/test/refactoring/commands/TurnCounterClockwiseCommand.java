package ru.sbt.test.refactoring.commands;

import ru.sbt.test.refactoring.behaviours.interfaces.CounterClockwiseTurnable;

public class TurnCounterClockwiseCommand implements Command {
    private final int count;
    private final CounterClockwiseTurnable counterClockwiseTurnable;

    public TurnCounterClockwiseCommand(CounterClockwiseTurnable counterClockwiseTurnable) {
        this(counterClockwiseTurnable, 1);
    }

    public TurnCounterClockwiseCommand(CounterClockwiseTurnable counterClockwiseTurnable, int count) {
        this.counterClockwiseTurnable = counterClockwiseTurnable;
        this.count = count;
    }

    public void execute() {
        for (int i = 0; i < count; i++) {
            counterClockwiseTurnable.turnLeft();
        }
    }
}
