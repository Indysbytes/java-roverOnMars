package com.indy.rover;

import com.indy.rover.movement.Forward;
import com.indy.rover.movement.LeftTurn;
import com.indy.rover.movement.Maneuvor;
import com.indy.rover.movement.RightTurn;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * I did this with limited time please ask for details if not sure about anything.
 *
 * Assumptions:
 * * The main entry point is the Mars class which will set up the Rover class and perform some basic validation on the input string.
 * * I did not write unit testing code on the Mars class for simple Input validation as I assumed it was not essential for this test and
 * * can be easily produced it if needed.
 * * I did not use any dependency injection or IOC as I assumed this is a small light application to test code design and did not warrant
 * * full context creation application.
 *
 * * I created the Rover class to encapsulate the receiving instructions, moving and reporting its position on the grid.
 * * I have unit tested the Rover class heavily to cover as much as I can with time and so left some basic unit testing from supporting classes
 * * as they are covered by the Rover class and did not want duplication. I have used the "jacoco-maven-plugin" to do code coverage.
 *
 * * The Rover class will perform limited validation for each move i.e. it tests if the boundary is reached. This demonstrates validation can
 * * be achieved but more specifications would be required. The boundary is (0-5, 0-5).
 * * A simple validation is made on the setting of the position however a more involved validator can be injected to enhance the constraint.
 *
 * * I did not create any constraints in the Position class as I wanted to keep it clean, just POJO.
 * * I write unit test for toString() only of the Position class as it is used heavily, all the methods are generated by the IDE and is a POJO.
 * * The Position class is immutable for safety.
 * 
 * * The Maneuvor interface is created to facilitate the development of maneuvors and scale e.g.
 * * when a Back maneuvor is needed a new class implementing Maneuvor is created and added to the map of Maneuvors, no other code is needed.
 *
 * * I did not use any loggers as I assumed this is meant to be a simple small application, logging can easily be implemented with r.g. slf4j or the logging class.
 *
 * How to run the app.
 *
 * I have used Netbeans 7.2 on an Ubuntu 12.04 LTS OS with JDK 1.7. and Maven 3.
 *
 * I have used the assembly pluggin so you can run this from the cmd line with Maven.
 * After extracting to a directory you should see:
 *       src
 *       pom.xml
 *
 * run Maven
 *  $ maven clean install
 *
 * then you should see the target directory.
 *       src
 *       pom.xml
 *       target
 * 
 * make sure the Rover-1.0-RELEASE.jar file is in the target directory and has run permissions. (sudo chmod +x target/Rover-1.0-RELEASE.jar)
 * then run the app supplying the instructions 
 *
 * $ java -jar target/Rover-1.0-RELEASE.jar Mars "FFL"
 *
 *
 */
public class Mars {
    public static final String INSTRUCTION_PATTERN = "[FLR]*";
    private Rover rover;

    public static void main( String[] args ) {
        System.out.println( "---------------------------------------------------" );
        System.out.println("");

        Mars mars = new Mars();

        if(mars.valid(args)){
            String instructions = args[1].toUpperCase();
            mars.moveRover(instructions);
        }
        else{
            System.out.println("Invalid instructions were submitted, only letters F,L and R are allowed.: usage Mars 'FLFR' ");
        }

        System.out.println("");
        System.out.println( "---------------------------------------------------" );
    }

    /**
     * Constructor to initiate the Rover module with a map of maneuvors.
     */
    public Mars() {
        rover = new Rover(getManeuvors());
    }


    /**
     * Perfors a limited validation.
     * Valid letters are F, L, R.
     *
     * @param instructions, the string containing instructions
     * @return true when the instruction contains at least on letter of valid instruction.
     */
    private boolean valid(String[] instructions){
        boolean result = false;

        if(instructions != null && instructions.length > 1 ){
            result = (instructions[1].matches(INSTRUCTION_PATTERN));
        }

        return result;
    }

    /**
     * Performs the moves as per instructions in parameter passed in.
     * Rover's last good position is set and is reported or obtained via the getPosition() method.
     *
     * @param instructions, the String containing the letters of the move.
     */
    private void moveRover(String instructions) {
        try {
            rover.move(instructions);
            System.out.println("After the instructions Rover's position is : " + rover.getPosition());
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Rover was unable to follow further instructions Rover's position before the offending instruction is : " + rover.getPosition());
        }
    }

    // this map could be injected by a container like Guice/Spring.
    private Map<Character, Maneuvor>  getManeuvors() {
        Map<Character, Maneuvor> maneuvors = new HashMap<>();

        maneuvors.put(Maneuvor.MOVE_FORWARD, new Forward());
        maneuvors.put(Maneuvor.TURN_LEFT, new LeftTurn());
        maneuvors.put(Maneuvor.TURN_RIGHT, new RightTurn());

        return maneuvors;
    }
}
