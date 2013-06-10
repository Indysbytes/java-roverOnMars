package com.indy.rover;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.indy.rover.Orientation.*;
import com.indy.rover.movement.Forward;
import com.indy.rover.movement.LeftTurn;
import com.indy.rover.movement.Maneuvor;
import com.indy.rover.movement.RightTurn;
import java.util.HashMap;
import java.util.Map;

public class RoverTest {

    private Rover rover;


    @Before
    public void setUp(){
        rover = new Rover(getManeuvors());
    }

    @Test
    public void shouldMoveForwardNorth() {
        // given
        String instructions = "F";
        Position expected = new Position(1, 0, NORTH);
        // when
        rover.move(instructions);

        Position actual = rover.getPosition();
        // then
        assertTrue("new position shoulbe 1, 0, NORHT", actual.equals(expected));
    }

    @Test
    public void shouldMoveForwardSouth() {
        // given
        rover.setPosition(new Position(1, 1, SOUTH));
        String instructions = "F";
        Position expected = new Position(0, 1, SOUTH);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 0, 1, SOUTH", actual.equals(expected));
    }

    @Test
    public void shouldMoveForwardEast() {
        // given
        rover.setPosition(new Position(1, 1, EAST));
        String instructions = "F";
        Position expected = new Position(1, 2, EAST);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 2, EAST", actual.equals(expected));
    }

    @Test
    public void shouldMoveForwardWest() {
        // given
        rover.setPosition(new Position(1, 1, WEST));
        String instructions = "F";
        Position expected = new Position(1, 0, WEST);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 0, WEST", actual.equals(expected));
    }

    @Test
    public void shouldTurnLeftFromNorth() {
        // given
        rover.setPosition(new Position(1, 1, NORTH));
        String instructions = "L";
        Position expected = new Position(1, 1, WEST);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 1, WEST", actual.equals(expected));
    }

    @Test
    public void shouldTurnLeftFromWest() {
        // given
        rover.setPosition(new Position(1, 1, WEST));
        String instructions = "L";
        Position expected = new Position(1, 1, SOUTH);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 1, SOUTH", actual.equals(expected));
    }

    @Test
    public void shouldTurnLeftFromSouth() {
        // given
        rover.setPosition(new Position(1, 1, SOUTH));
        String instructions = "L";
        Position expected = new Position(1, 1, EAST);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 1, EAST", actual.equals(expected));
    }

    @Test
    public void shouldTurnLeftFromEast() {
        // given
        rover.setPosition(new Position(1, 1, EAST));
        String instructions = "L";
        Position expected = new Position(1, 1, NORTH);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 1, NORTH", actual.equals(expected));
    }

    @Test
    public void shouldTurnRightFromNorth() {
        // given
        rover.setPosition(new Position(1, 1, NORTH));
        String instructions = "R";
        Position expected = new Position(1, 1, EAST);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 1, EAST", actual.equals(expected));
    }

    @Test
    public void shouldTurnRightFromEast() {
        // given
        rover.setPosition(new Position(1, 1, EAST));
        String instructions = "R";
        Position expected = new Position(1, 1, SOUTH);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 1, SOUTH", actual.equals(expected));
    }

    @Test
    public void shouldTurnRightFromSouth() {
        // given
        rover.setPosition(new Position(1, 1, SOUTH));
        String instructions = "R";
        Position expected = new Position(1, 1, WEST);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 1, WEST", actual.equals(expected));
    }

    @Test
    public void shouldTurnRightFromWest() {
        // given
        rover.setPosition(new Position(1, 1, WEST));
        String instructions = "R";
        Position expected = new Position(1, 1, NORTH);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 1, NORTH", actual.equals(expected));
    }

    @Test
    public void shouldTurnRightAndMoveForward() {
        // given
        rover.setPosition(new Position(1, 1, NORTH));
        String instructions = "RF";
        Position expected = new Position(1, 2, EAST);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 2, EAST", actual.equals(expected));
    }

    @Test
    public void shouldTurnRightAndMoveForwardAndTurnLeft() {
        // given
        rover.setPosition(new Position(1, 1, NORTH));
        String instructions = "RFL";
        Position expected = new Position(1, 2, NORTH);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 1, 2, NORTH", actual.equals(expected));
    }

    @Test
    public void testMultipleForwardAndTurn() {
        // given
        rover.setPosition(new Position(1, 1, NORTH));
        String instructions = "RFLFFLL";
        Position expected = new Position(3, 2, SOUTH);
        // when
        Position actual = rover.move(instructions);

        // then
        assertTrue("new position shoulbe 3, 2, SOUTH", actual.equals(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReachBoudary() {
        // given
        rover.setPosition(new Position(0, 0, NORTH));
        String instructions = "LF";
        // when
        rover.move(instructions);

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldReachBoudaryAtTop() {
        // given
        rover.setPosition(new Position(4, 3, NORTH));
        String instructions = "RFFF";
        // when
        rover.move(instructions);

    }


    private Map<Character, Maneuvor>  getManeuvors() {
        Map<Character, Maneuvor> maneuvors = new HashMap<>();

        maneuvors.put(Maneuvor.MOVE_FORWARD, new Forward());
        maneuvors.put(Maneuvor.TURN_LEFT, new LeftTurn());
        maneuvors.put(Maneuvor.TURN_RIGHT, new RightTurn());

        return maneuvors;
    }


}

