package ru.sbt.test.refactoring;

import junit.framework.TestCase;
import ru.sbt.test.refactoring.commands.*;
import ru.sbt.test.refactoring.exceptions.InDitchException;

import java.util.ArrayList;
import java.util.List;

public class RobotTest extends TestCase {

    public void testShouldMoveForward() {
        Robot robot = new Robot(new MovementArea(5, 5));
        Command forwardMoveCommand = new ForwardMoveCommand(robot);
        forwardMoveCommand.execute();
        assertEquals(0, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldMoveBack() {
        Robot robot = new Robot(new MovementArea(5, 5));
        Command backwardMoveCommand = new BackwardMoveCommand(robot);
        backwardMoveCommand.execute();
        assertEquals(0, robot.getPosition().getX());
        assertEquals(-1, robot.getPosition().getY());
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldMoveRight() {
        Robot robot = new Robot(new MovementArea(5, 5));
        Command rightMoveCommand = new RightMoveCommand(robot);
        rightMoveCommand.execute();
        assertEquals(1, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldMoveLeft() {
        Robot robot = new Robot(new MovementArea(5, 5));
        Command leftMoveCommand = new LeftMoveCommand(robot);
        leftMoveCommand.execute();
        assertEquals(-1, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldTurnRight() {
        Robot robot = new Robot(new MovementArea(5, 5));
        Command turnCommand = new TurnClockwiseCommand(robot);
        turnCommand.execute();
        assertEquals(Orientation.EAST, robot.getOrientation());
        turnCommand.execute();
        assertEquals(Orientation.SOUTH, robot.getOrientation());
        turnCommand.execute();
        assertEquals(Orientation.WEST, robot.getOrientation());
        turnCommand.execute();
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldTurnLeft() {
        Robot robot = new Robot(new MovementArea(5, 5));
        Command turnCommand = new TurnCounterClockwiseCommand(robot);
        turnCommand.execute();
        assertEquals(Orientation.WEST, robot.getOrientation());
        turnCommand.execute();
        assertEquals(Orientation.SOUTH, robot.getOrientation());
        turnCommand.execute();
        assertEquals(Orientation.EAST, robot.getOrientation());
        turnCommand.execute();
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldTurnAndMoveInTheRightDirection() {
        Robot robot = new Robot(new MovementArea(5, 5));
        new RightMoveCommand(robot).execute();
        assertEquals(1, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        new BackwardMoveCommand(robot).execute();
        assertEquals(1, robot.getPosition().getX());
        assertEquals(-1, robot.getPosition().getY());
        new LeftMoveCommand(robot).execute();
        assertEquals(0, robot.getPosition().getX());
        assertEquals(-1, robot.getPosition().getY());
        new ForwardMoveCommand(robot).execute();
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
    }

    public void testShouldThrowExceptionIfFallsOffPlateau() {
        Robot tractor = new Robot(new MovementArea(5, 5));
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
        Robot robot = new Robot(new MovementArea(5, 5));
        commands.add(new ForwardMoveCommand(robot));
        commands.add(new TurnClockwiseCommand(robot));
        commands.add(new TurnCounterClockwiseCommand(robot));
        commands.add(new BackwardMoveCommand(robot));
        Command command = new MacroCommand(commands);
        command.execute();
        assertEquals(0, robot.getPosition().getY());
        assertEquals(0, robot.getPosition().getX());
    }

    public void testOverloadCommands() {
        Robot tractor = new Robot(new MovementArea(5, 5));
        Command forwardCommand = new ForwardMoveCommand(tractor, 5);
        forwardCommand.execute();
        assertEquals(5, tractor.getPosition().getY());
        Command turnCommand = new TurnClockwiseCommand(tractor, 5);
        turnCommand.execute();
        assertEquals(Orientation.EAST, tractor.getOrientation());
    }
}

