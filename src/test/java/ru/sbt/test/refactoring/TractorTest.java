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
        Command forwardMoveCommand = new ForwardMoveCommand(tractor);
        forwardMoveCommand.execute();
        assertEquals(0, tractor.getPosition().getX());
        assertEquals(1, tractor.getPosition().getY());
    }

    public void testShouldTurn() {
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        Command turnCommand = new TurnClockwiseCommand(tractor);
        turnCommand.execute();
        assertEquals(Orientation.EAST, tractor.getOrientation());
        turnCommand.execute();
        assertEquals(Orientation.SOUTH, tractor.getOrientation());
        turnCommand.execute();
        assertEquals(Orientation.WEST, tractor.getOrientation());
        turnCommand.execute();
        assertEquals(Orientation.NORTH, tractor.getOrientation());
    }

    public void testShouldTurnAndMoveInTheRightDirection() {
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        Command turnCommand = new TurnClockwiseCommand(tractor);
        turnCommand.execute();
        Command forwardMoveCommand = new ForwardMoveCommand(tractor);
        forwardMoveCommand.execute();
        assertEquals(1, tractor.getPosition().getX());
        assertEquals(0, tractor.getPosition().getY());
        turnCommand.execute();
        forwardMoveCommand.execute();
        assertEquals(1, tractor.getPosition().getX());
        assertEquals(-1, tractor.getPosition().getY());
        turnCommand.execute();
        forwardMoveCommand.execute();
        assertEquals(0, tractor.getPosition().getX());
        assertEquals(-1, tractor.getPosition().getY());
        turnCommand.execute();
        forwardMoveCommand.execute();
        assertEquals(0, tractor.getPosition().getX());
        assertEquals(0, tractor.getPosition().getY());
    }

    public void testShouldThrowExceptionIfFallsOffPlateau() {
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        Command forwardMoveCommand = new ForwardMoveCommand(tractor);
        forwardMoveCommand.execute();
        forwardMoveCommand.execute();
        forwardMoveCommand.execute();
        forwardMoveCommand.execute();
        forwardMoveCommand.execute();
        try {
            forwardMoveCommand.execute();
            fail("Tractor was expected to fall off the plateau");
        } catch (InDitchException expected) {
        }
    }

    public void testMacroCommand() {
        List<Command> commands = new ArrayList<Command>();
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        commands.add(new ForwardMoveCommand(tractor));
        commands.add(new TurnClockwiseCommand(tractor));
        commands.add(new TurnClockwiseCommand(tractor));
        commands.add(new ForwardMoveCommand(tractor));
        Command command = new MacroCommand(commands);
        command.execute();
        assertEquals(0, tractor.getPosition().getY());
        assertEquals(0, tractor.getPosition().getX());
    }

    public void testOverloadCommands() {
        Tractor tractor = new Tractor(new MovementArea(5, 5));
        Command forwardCommand = new ForwardMoveCommand(tractor, 5);
        forwardCommand.execute();
        assertEquals(5, tractor.getPosition().getY());
        Command turnCommand = new TurnClockwiseCommand(tractor, 5);
        turnCommand.execute();
        assertEquals(Orientation.EAST, tractor.getOrientation());
    }
}