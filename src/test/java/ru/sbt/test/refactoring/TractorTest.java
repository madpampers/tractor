package ru.sbt.test.refactoring;

import junit.framework.TestCase;
import ru.sbt.test.refactoring.commands.Command;
import ru.sbt.test.refactoring.commands.ForwardMoveCommand;
import ru.sbt.test.refactoring.commands.MacroCommand;
import ru.sbt.test.refactoring.commands.TurnClockwiseCommand;
import ru.sbt.test.refactoring.exceptions.InDitchException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben
 */
public class TractorTest extends TestCase {

    public void testShouldMoveForward() {
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        Command forwardMoveCommand = new ForwardMoveCommand(tractor.getMovementBehaviour());
        tractor.move(forwardMoveCommand);
        assertEquals(0, tractor.getPosition().getX());
        assertEquals(1, tractor.getPosition().getY());
    }

    public void testShouldTurn() {
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        Command turnCommand = new TurnClockwiseCommand(tractor.getTurnBehaviour());
        tractor.move(turnCommand);
        assertEquals(Orientation.EAST, tractor.getOrientation());
        tractor.move(turnCommand);
        assertEquals(Orientation.SOUTH, tractor.getOrientation());
        tractor.move(turnCommand);
        assertEquals(Orientation.WEST, tractor.getOrientation());
        tractor.move(turnCommand);
        assertEquals(Orientation.NORTH, tractor.getOrientation());
    }

    public void testShouldTurnAndMoveInTheRightDirection() {
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        Command turnCommand = new TurnClockwiseCommand(tractor.getTurnBehaviour());
        tractor.move(turnCommand);
        Command forwardMoveCommand = new ForwardMoveCommand(tractor.getMovementBehaviour());
        tractor.move(forwardMoveCommand);
        assertEquals(1, tractor.getPosition().getX());
        assertEquals(0, tractor.getPosition().getY());
        tractor.move(turnCommand);
        tractor.move(forwardMoveCommand);
        assertEquals(1, tractor.getPosition().getX());
        assertEquals(-1, tractor.getPosition().getY());
        tractor.move(turnCommand);
        tractor.move(forwardMoveCommand);
        assertEquals(0, tractor.getPosition().getX());
        assertEquals(-1, tractor.getPosition().getY());
        tractor.move(turnCommand);
        tractor.move(forwardMoveCommand);
        assertEquals(0, tractor.getPosition().getX());
        assertEquals(0, tractor.getPosition().getY());
    }

    public void testShouldThrowExceptionIfFallsOffPlateau() {
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        Command forwardMoveCommand = new ForwardMoveCommand(tractor.getMovementBehaviour());
        tractor.move(forwardMoveCommand);
        tractor.move(forwardMoveCommand);
        tractor.move(forwardMoveCommand);
        tractor.move(forwardMoveCommand);
        tractor.move(forwardMoveCommand);
        try {
            forwardMoveCommand.execute();
            fail("Tractor was expected to fall off the plateau");
        } catch (InDitchException expected) {
        }
    }

    public void testMacroCommand() {
        List<Command> commands = new ArrayList<Command>();
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        Command moveForward = new ForwardMoveCommand(tractor.getMovementBehaviour());
        Command turnClockwise = new TurnClockwiseCommand(tractor.getTurnBehaviour());
        commands.add(moveForward);
        commands.add(turnClockwise);
        commands.add(turnClockwise);
        commands.add(moveForward);
        Command command = new MacroCommand(commands);
        tractor.move(command);
        assertEquals(0, tractor.getPosition().getY());
        assertEquals(0, tractor.getPosition().getX());
    }

    public void testOverloadCommands() {
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        Command forwardCommand = new ForwardMoveCommand(tractor.getMovementBehaviour(), 5);
        tractor.move(forwardCommand);
        assertEquals(5, tractor.getPosition().getY());
        Command turnCommand = new TurnClockwiseCommand(tractor.getTurnBehaviour(), 5);
        tractor.move(turnCommand);
        assertEquals(Orientation.EAST, tractor.getOrientation());
    }
}