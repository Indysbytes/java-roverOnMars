/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indy.rover.movement;

import com.indy.rover.Position;

/**
 *
 * @author indy
 */
public interface Maneuvor {
    public static final Character MOVE_FORWARD = new Character('F');
    public static final Character TURN_LEFT = new Character('L');
    public static final Character TURN_RIGHT = new Character('R');

    public Position execute(Position currentPosition);

}
