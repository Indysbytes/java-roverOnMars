/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indy.rover;

/**
 *
 * @author indy
 */
public class Rover {
    public static final char MOVE_FORWARD = 'F';
    public static final char TURN_LEFT = 'L';
    public static final char TURN_RIGHT = 'R';
    public static final int MAX_POS_X = 4;
    public static final int MIN_X_POS = 0;
    public static final int MAX_POS_Y = 4;
    public static final int MIN_Y_POS = 0;

    private Position position = new Position();

    public Position move(String instructions) {
        char instruction;
        final int length = instructions.length() -1;

        for (int i=MIN_X_POS; i<= length; i++) {
            instruction = instructions.charAt(i);

            if(MOVE_FORWARD == instruction){
                setPosition(moveForward());
            }

            else if(TURN_LEFT == instruction){
                setPosition(turnLeft());
            }

            else if( TURN_RIGHT == instruction){
                setPosition(turnRight());
            }
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

    private Position moveForward() {
        Position result = null;
        if(position.getOrientation() == Orientation.NORTH){
            result =  new Position(position.getX() + 1, position.getY(), position.getOrientation());
        }

        else if(position.getOrientation() == Orientation.SOUTH){
            result =  new Position(position.getX() - 1, position.getY(), position.getOrientation());
        }

        else if(position.getOrientation() == Orientation.EAST){
            result =  new Position(position.getX(), position.getY() + 1, position.getOrientation());
        }

        else if(position.getOrientation() == Orientation.WEST){
            result =  new Position(position.getX(), position.getY() - 1, position.getOrientation());
        }
        return result;
    }

    private Position turnLeft() {
        Position result = null;
        if(position.getOrientation() == Orientation.NORTH){
            result = new Position(position.getX(), position.getY(), Orientation.WEST);
        }

        else if(position.getOrientation() == Orientation.WEST){
            result = new Position(position.getX(), position.getY(), Orientation.SOUTH);
        }

        else if(position.getOrientation() == Orientation.SOUTH){
            result = new Position(position.getX(), position.getY(), Orientation.EAST);
        }

        else if(position.getOrientation() == Orientation.EAST){
            result = new Position(position.getX(), position.getY(), Orientation.NORTH);
        }
        return result;
    }

    private Position turnRight() {
        Position result = null;
        if(position.getOrientation() == Orientation.NORTH){
            result = new Position(position.getX(), position.getY(), Orientation.EAST);
        }

        else if(position.getOrientation() == Orientation.EAST){
            result = new Position(position.getX(), position.getY(), Orientation.SOUTH);
        }

        else if(position.getOrientation() == Orientation.SOUTH){
            result = new Position(position.getX(), position.getY(), Orientation.WEST);
        }

        else if(position.getOrientation() == Orientation.WEST){
            result = new Position(position.getX(), position.getY(), Orientation.NORTH);
        }
        return result;
    }



}
