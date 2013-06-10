package com.indy.rover;

import com.indy.rover.movement.Forward;
import com.indy.rover.movement.LeftTurn;
import com.indy.rover.movement.Maneuvor;
import com.indy.rover.movement.RightTurn;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author indy
 */
public class Rover {
    public static final int MAX_POS_X = 4;
    public static final int MIN_X_POS = 0;
    public static final int MAX_POS_Y = 4;
    public static final int MIN_Y_POS = 0;

    private Maneuvor forward = new Forward();
    private Maneuvor leftTurn = new LeftTurn();
    private Maneuvor rightTurn = new RightTurn();
    private Map<Character, Maneuvor> maneuvors = new HashMap<>();

    private Position position = new Position();

    public Rover() {
        init();
    }

    private void init() {
        maneuvors.put(Maneuvor.MOVE_FORWARD, this.forward);
        maneuvors.put(Maneuvor.TURN_LEFT, this.leftTurn);
        maneuvors.put(Maneuvor.TURN_RIGHT, this.rightTurn);
    }

    public Position move(String instructions) {
        final int length = instructions.length() -1;

        for (int i=MIN_X_POS; i<= length; i++) {
            setPosition((maneuvors.get(instructions.charAt(i))).execute(position));
        }

        return position;
    }

    public void setPosition(Position newPosition) {
        if(newPosition.getX() > MAX_POS_X || newPosition.getX() < MIN_X_POS || newPosition.getY() > MAX_POS_Y || newPosition.getY() < MIN_Y_POS){
            throw new IllegalArgumentException("Unable to perform instruction as the boundary has been reached.");
        }
        this.position = new Position(newPosition.getX(), newPosition.getY(), newPosition.getOrientation());
    }

    public Position getPosition() {
        return position;
    }



}
