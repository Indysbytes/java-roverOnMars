package com.indy.rover;

import com.indy.rover.movement.Forward;
import com.indy.rover.movement.LeftTurn;
import com.indy.rover.movement.Maneuvor;
import com.indy.rover.movement.RightTurn;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Mars 
{
    private Rover rover;

    public static void main( String[] args ) {
        System.out.println( "---------------------------------------------------" );

        Mars mars = new Mars();
        String instructions = args[1];
        if(instructions != null && instructions.length() > 0){
            mars.moveRover(instructions);
        }
        else{
            System.out.println("No valid instructions were submitted : usage Mar 'FLR' ");
        }

        System.out.println( "---------------------------------------------------" );
    }

    private void moveRover(String instructions) {
        rover = new Rover(getManeuvors());
        Position currentPosition = new Position();
        try {
            currentPosition = rover.move(instructions);
            System.out.println("After the instructions Rover's position is :" + currentPosition);
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Rover was unable to follow instructions Rover's position is :" + currentPosition);
        }
    }

    private Map<Character, Maneuvor>  getManeuvors() {
        Map<Character, Maneuvor> maneuvors = new HashMap<>();

        maneuvors.put(Maneuvor.MOVE_FORWARD, new Forward());
        maneuvors.put(Maneuvor.TURN_LEFT, new LeftTurn());
        maneuvors.put(Maneuvor.TURN_RIGHT, new RightTurn());

        return maneuvors;
    }
}
