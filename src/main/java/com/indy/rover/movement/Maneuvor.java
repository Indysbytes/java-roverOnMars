package com.indy.rover.movement;

import com.indy.rover.Position;

/**
 * The interface to force the behaviour of all maneuvors on the grid.
 * The static members are there for convenience.
 *
 * When a new Maneuvor is needed e.g. a Back move then simply create any new class to implement this interface
 * and implement change in position according the back move.
 *
 */
public interface Maneuvor {
    public static final Character MOVE_FORWARD = new Character('F');
    public static final Character TURN_LEFT = new Character('L');
    public static final Character TURN_RIGHT = new Character('R');

    /**
     * Perform the move relative to the position in currentPosition.
     * @param currentPosition the current point in the grid.
     * @return Position the new point in the grid.
     */
    public Position execute(Position currentPosition);

}
