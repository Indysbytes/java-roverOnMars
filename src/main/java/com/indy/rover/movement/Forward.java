package com.indy.rover.movement;

import com.indy.rover.Orientation;
import com.indy.rover.Position;

/**
 *
 * @author indy
 */
public class Forward implements Maneuvor {

    @Override
    public Position execute(Position currentPosition) {
        Position result = currentPosition;
        if (currentPosition.getOrientation() == Orientation.NORTH) {
            result = new Position(currentPosition.getX() + 1, currentPosition.getY(), currentPosition.getOrientation());
        }
        else if (currentPosition.getOrientation() == Orientation.SOUTH) {
            result = new Position(currentPosition.getX() - 1, currentPosition.getY(), currentPosition.getOrientation());
        }
        else if (currentPosition.getOrientation() == Orientation.EAST) {
            result = new Position(currentPosition.getX(), currentPosition.getY() + 1, currentPosition.getOrientation());
        }
        else if (currentPosition.getOrientation() == Orientation.WEST) {
            result = new Position(currentPosition.getX(), currentPosition.getY() - 1, currentPosition.getOrientation());
        }
        return result;
    }
}
