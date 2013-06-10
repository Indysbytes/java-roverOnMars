package com.indy.rover.movement;

import static com.indy.rover.Orientation.*;
import com.indy.rover.Position;

/**
 * This class encapsulates the forward motion.
 * The currentPosition is adjusted to reflect the new position by moving forward one point in
 * the direction pointed to by the orientation value of the position.
 *
 */
public class Forward implements Maneuvor {

    /**
     * Moves forward one position relative to the currentPosition on the grid.
     *
     * @param currentPosition
     * @return the new position after moving forward in direction of Orientation.
     */
    @Override
    public Position execute(Position currentPosition) {
        Position result = currentPosition;
        if (currentPosition.getOrientation() == NORTH) {
            result = new Position(currentPosition.getX() + 1, currentPosition.getY(), currentPosition.getOrientation());
        }
        else if (currentPosition.getOrientation() == SOUTH) {
            result = new Position(currentPosition.getX() - 1, currentPosition.getY(), currentPosition.getOrientation());
        }
        else if (currentPosition.getOrientation() == EAST) {
            result = new Position(currentPosition.getX(), currentPosition.getY() + 1, currentPosition.getOrientation());
        }
        else if (currentPosition.getOrientation() == WEST) {
            result = new Position(currentPosition.getX(), currentPosition.getY() - 1, currentPosition.getOrientation());
        }
        
        return result;
    }
}
