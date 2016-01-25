package com.commonbond.problem2.models;

/**
 * Shockwave POJO
 */
public class Shockwave {
    static public String LEFT = "<";
    static public String RIGHT = ">";

    private int position;
    // -1 direction is left; +1 direction is right
    private int directionMath;
    private String direction;
    private int force;

    public Shockwave(int position, int direction, int force) {
        this.position = position;
        this.directionMath = direction;
        if (direction < 0) {
            this.direction = Shockwave.LEFT;
        } else {
            this.direction = Shockwave.RIGHT;
        }
        this.force = force;
    }

    public int getPosition() {
        return position;
    }

    public String getDirection() {
        return direction;
    }

    /**
     * Move in our current direction by amount of force
     * @return  The new position
     */
    public int move() {
        this.position = this.position + (force * directionMath);
        return this.position;
    }
}
