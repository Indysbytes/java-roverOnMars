/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indy.rover;

/**
 *
 * @author indy
 */
public class Position {

    private int x = 0;
    private int y = 0;
    private Orientation orientation = Orientation.NORTH;


    /**
     *
     * @param x
     * @param y
     * @param orientation
     */
    public Position(int x, int y, com.indy.rover.Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    Position() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.x;
        hash = 47 * hash + this.y;
        hash = 47 * hash + (this.orientation != null ? this.orientation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.x != other.getX()) {
            return false;
        }
        if (this.y != other.getY()) {
            return false;
        }
        if (this.orientation != other.getOrientation()) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Position{" + "x=" + x + ", y=" + y + ", orientation=" + orientation + '}';
    }



}
