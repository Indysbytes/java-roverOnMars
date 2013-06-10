package com.indy.rover;

import com.indy.rover.movement.Maneuvor;
import java.util.HashMap;
import java.util.Map;

/**
 * The Rover class encapsulates the rover receiving instructions, moving and reporting its position.
 * I have unit tested the Rover class heavily to cover as much as I can and so left some basic unit testing from supporting classes
 * as they are covered by the Rover class and did not want duplication.
 *
 * The Rover class will perform limited validation for each maneuvor i.e. it tests if the boundary is reached. This demonstrates validation can
 * achieved but more specifications would be required. The boundary is (0-5, 0-5).
 *
 * The class takes a new map of maneuvors which are the helpers classes that Rover will use to change its position.
 * Rover does come preloaded with any maneuvors.
 *
 * A simple validation is made on the setting of the position however a more involved validator can be injected to enhance the constraint.
 *
 * @author indy reddy
 */
public class Rover {
    public static final int MAX_POS_X = 4;
    public static final int MIN_X_POS = 0;
    public static final int MAX_POS_Y = 4;
    public static final int MIN_Y_POS = 0;

    private Map<Character, Maneuvor> maneuvors = new HashMap<>();

    // this defaults to start position on the grid.
    private Position position = new Position();

    /**
     * Constructor, takes a map of maneuvors Rover can make on the grid.
     *
     * @param maneuvors, map holding the maneuvors.
     */
    public Rover(Map<Character, Maneuvor> maneuvors) {
        this.maneuvors.putAll(maneuvors);
    }

    /**
     * Performs the moves as per instructions in parameter passed in.
     * Rover's last good position is set and is reported or obtained via the getPosition() method.
     * Permitted letter for the instruction are:
     * F - move forward.
     * L - turn left 90 degrees.
     * R - turn right 90 degrees.
     *
     * @param instructions
     * @return Position, the position of Rover in the grid after performing the moves in the instruction.
     */
    public Position move(String instructions) {
        final int length = instructions.length() -1;

        for (int i=0; i<= length; i++) {
            setPosition((maneuvors.get(instructions.charAt(i))).execute(position));
        }

        return position;
    }

    /**
     * Changes the position of Rover.
     * A simple check is made to account for Rover not moving outside the grid.
     * @param newPosition, next position Rove will be.
     * @throws IllegalArgumentException, when the new position would result in Rover being placed outside the grid.
     */
    public void setPosition(Position newPosition) {
        if(newPosition.getX() > MAX_POS_X || newPosition.getX() < MIN_X_POS || newPosition.getY() > MAX_POS_Y || newPosition.getY() < MIN_Y_POS){
            throw new IllegalArgumentException("Unable to perform instruction as the boundary has been reached.");
        }
        this.position = new Position(newPosition.getX(), newPosition.getY(), newPosition.getOrientation());
    }

    /**
     * Returns the current grid position.
     * @return the position in grid coordinates.
     */
    public Position getPosition() {
        return position;
    }

}
