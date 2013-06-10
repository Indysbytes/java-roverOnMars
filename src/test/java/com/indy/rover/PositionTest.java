/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indy.rover;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author indy
 */
public class PositionTest {

    public PositionTest() {
    }

    /**
     * Test of toString method, of class Position.
     */
    @Test
    public void testToString() {
        // given
        Position instance = new Position();
        String expResult = "Position{x=0, y=0, orientation=NORTH}";
        // when
        String result = instance.toString();
        // then
        assertEquals(expResult, result);
    }
}