package com.indy.rover.movement;

import static com.indy.rover.Orientation.*;
import com.indy.rover.Position;

/**
 * This class encapsulates the Right turning motion.
 * The orientation is adjusted to reflect the new orientation by turning once 90 degrees to the right.
 *
  */
public class RightTurn implements Maneuvor{

    /**
     * Make a turn to the right relative to the orientation on the grid.
     * @param currentPosition
     * @return Position, the new position after making the turn.
     */
    @Override
    public Position execute(Position currentPosition) {
        Position result = currentPosition;
        if(currentPosition.getOrientation() == NORTH){
            result = new Position(currentPosition.getX(), currentPosition.getY(), EAST);
        }

        else if(currentPosition.getOrientation() == EAST){
            result = new Position(currentPosition.getX(), currentPosition.getY(), SOUTH);
        }

        else if(currentPosition.getOrientation() == SOUTH){
            result = new Position(currentPosition.getX(), currentPosition.getY(), WEST);
        }

        else if(currentPosition.getOrientation() == WEST){
            result = new Position(currentPosition.getX(), currentPosition.getY(), NORTH);
        }

        return result;
    }
}
