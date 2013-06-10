package com.indy.rover;

/**
 * Class to encapsulate the idea of a position on the grid.
 * The grid consists of an x & y coordinate and the orientation which is the direction the object is facing.
 * This class is immutable.
 *
 * The default constructor will set the position to the start of the grid (0, 0, NORTH).
 * 
 */
public class Position {

    private final int x;
    private final int y;
    private final Orientation orientation;


    /**
     * Creates a Position object with the point in the grid as per params.
     * @param x, the x coordinate on the grid
     * @param y, the y coordinate on the grid
     * @param orientation the direction of the object is facing.
     */
    public Position(int x, int y, com.indy.rover.Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    /**
     * Default constructor, the position is set to the start of the grid facing up/north.
     */
    public Position() {
        x = 0;
        y = 0;
        orientation = Orientation.NORTH;
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
