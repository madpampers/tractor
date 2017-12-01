package ru.sbt.test.refactoring;

import junit.framework.TestCase;
import ru.sbt.test.refactoring.commands.*;
import ru.sbt.test.refactoring.exceptions.InDitchException;

import java.util.ArrayList;
import java.util.List;

public class RobotTest extends TestCase {

    public void testShouldMoveForward() {
        Skynet skynet = new Skynet();
        Robot robot = new Robot(new MovementArea(5, 5));
        Command forwardMoveCommand = new ForwardMoveCommand(robot);
        skynet.controlRobots(forwardMoveCommand);
        assertEquals(0, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldMoveBack() {
        Skynet skynet = new Skynet();
        Robot robot = new Robot(new MovementArea(5, 5));
        Command backwardMoveCommand = new BackwardMoveCommand(robot);
        skynet.controlRobots(backwardMoveCommand);
        assertEquals(0, robot.getPosition().getX());
        assertEquals(-1, robot.getPosition().getY());
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldMoveRight() {
        Skynet skynet = new Skynet();
        Robot robot = new Robot(new MovementArea(5, 5));
        Command rightMoveCommand = new RightMoveCommand(robot);
        skynet.controlRobots(rightMoveCommand);
        assertEquals(1, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldMoveLeft() {
        Skynet skynet = new Skynet();
        Robot robot = new Robot(new MovementArea(5, 5));
        Command leftMoveCommand = new LeftMoveCommand(robot);
        skynet.controlRobots(leftMoveCommand);
        assertEquals(-1, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldTurnRight() {
        Skynet skynet = new Skynet();
        Robot robot = new Robot(new MovementArea(5, 5));
        Command turnCommand = new TurnClockwiseCommand(robot);
        skynet.controlRobots(turnCommand);
        assertEquals(Orientation.EAST, robot.getOrientation());
        skynet.controlRobots(turnCommand);
        assertEquals(Orientation.SOUTH, robot.getOrientation());
        skynet.controlRobots(turnCommand);
        assertEquals(Orientation.WEST, robot.getOrientation());
        skynet.controlRobots(turnCommand);
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldTurnLeft() {
        Skynet skynet = new Skynet();
        Robot robot = new Robot(new MovementArea(5, 5));
        Command turnCommand = new TurnCounterClockwiseCommand(robot);
        skynet.controlRobots(turnCommand);
        assertEquals(Orientation.WEST, robot.getOrientation());
        skynet.controlRobots(turnCommand);
        assertEquals(Orientation.SOUTH, robot.getOrientation());
        skynet.controlRobots(turnCommand);
        assertEquals(Orientation.EAST, robot.getOrientation());
        skynet.controlRobots(turnCommand);
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    public void testShouldTurnAndMoveInTheRightDirection() {
        Skynet skynet = new Skynet();
        Robot robot = new Robot(new MovementArea(5, 5));
        skynet.controlRobots(new RightMoveCommand(robot));
        assertEquals(1, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        skynet.controlRobots(new BackwardMoveCommand(robot));
        assertEquals(1, robot.getPosition().getX());
        assertEquals(-1, robot.getPosition().getY());
        skynet.controlRobots(new LeftMoveCommand(robot));
        assertEquals(0, robot.getPosition().getX());
        assertEquals(-1, robot.getPosition().getY());
        skynet.controlRobots(new ForwardMoveCommand(robot));
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
    }

    public void testShouldThrowExceptionIfFallsOffPlateau() {
        Skynet skynet = new Skynet();
        Robot tractor = new Robot(new MovementArea(5, 5));
        Command forwardMoveCommand = new ForwardMoveCommand(tractor);
        skynet.controlRobots(forwardMoveCommand);
        skynet.controlRobots(forwardMoveCommand);
        skynet.controlRobots(forwardMoveCommand);
        skynet.controlRobots(forwardMoveCommand);
        skynet.controlRobots(forwardMoveCommand);
        try {
            forwardMoveCommand.execute();
            fail("Tractor was expected to fall off the plateau");
        } catch (InDitchException expected) {
        }
    }

    public void testMacroCommand() {
        Skynet skynet = new Skynet();
        List<Command> commands = new ArrayList<Command>();
        Robot robot = new Robot(new MovementArea(5, 5));
        commands.add(new ForwardMoveCommand(robot));
        commands.add(new TurnClockwiseCommand(robot));
        commands.add(new TurnCounterClockwiseCommand(robot));
        commands.add(new BackwardMoveCommand(robot));
        Command command = new MacroCommand(commands);
        skynet.controlRobots(command);
        assertEquals(0, robot.getPosition().getY());
        assertEquals(0, robot.getPosition().getX());
    }

    public void testOverloadCommands() {
        Skynet skynet = new Skynet();
        Robot tractor = new Robot(new MovementArea(5, 5));
        Command forwardCommand = new ForwardMoveCommand(tractor, 5);
        skynet.controlRobots(forwardCommand);
        assertEquals(5, tractor.getPosition().getY());
        Command turnCommand = new TurnClockwiseCommand(tractor, 5);
        skynet.controlRobots(turnCommand);
        assertEquals(Orientation.EAST, tractor.getOrientation());
    }
}

