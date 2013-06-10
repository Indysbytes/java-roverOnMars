package com.indy.rover.movement;

import com.indy.rover.Orientation;
import com.indy.rover.Position;

/**
 *
 * @author indy
 */
public class LeftTurn implements Maneuvor{

    @Override
    public Position execute(Position currentPosition) {
        Position result = currentPosition;
        if(currentPosition.getOrientation() == Orientation.NORTH){
            result = new Position(currentPosition.getX(), currentPosition.getY(), Orientation.WEST);
        }

        else if(currentPosition.getOrientation() == Orientation.WEST){
            result = new Position(currentPosition.getX(), currentPosition.getY(), Orientation.SOUTH);
        }

        else if(currentPosition.getOrientation() == Orientation.SOUTH){
            result = new Position(currentPosition.getX(), currentPosition.getY(), Orientation.EAST);
        }

        else if(currentPosition.getOrientation() == Orientation.EAST){
            result = new Position(currentPosition.getX(), currentPosition.getY(), Orientation.NORTH);
        }
        return result;
    }

}
