package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.behaviours.ClockwiseDirectionTurning;
import ru.sbt.test.refactoring.behaviours.ForwardMovement;
import ru.sbt.test.refactoring.commands.Command;

public class Tractor implements MovableByCommand {

    private ForwardMovement movementBehaviour;
    private ClockwiseDirectionTurning turnBehaviour;

    public Tractor(MovementArea area) {
        this.turnBehaviour = new ClockwiseDirectionTurning(Orientation.NORTH);
        this.movementBehaviour = new ForwardMovement(area, turnBehaviour);
    }

    public ForwardMovement getMovementBehaviour() {
        return movementBehaviour;
    }

    public void setMovementBehaviour(ForwardMovement movementBehaviour) {
        this.movementBehaviour = movementBehaviour;
    }

    public ClockwiseDirectionTurning getTurnBehaviour() {
        return turnBehaviour;
    }

    public void setTurnBehaviour(ClockwiseDirectionTurning turnBehaviour) {
        this.turnBehaviour = turnBehaviour;
    }

    public Orientation getOrientation() {
        return turnBehaviour.getOrientation();
    }

    public Position getPosition() {
        return movementBehaviour.getPosition();
    }

    public void move(Command command) {
        command.execute();
    }
}

