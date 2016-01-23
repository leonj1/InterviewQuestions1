package com.commonbond.problem2.models;

/**
 * Track bomb meta data
 */
public class Bomb {
    private int initialPosition;
    private int bombStrength;

    public Bomb(int initialPosition, int bombStrength) {
        this.initialPosition = initialPosition;
        this.bombStrength = bombStrength;
    }

    public int getBombStrength() {
        return bombStrength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bomb bomb = (Bomb) o;

        if (initialPosition != bomb.initialPosition) return false;
        return bombStrength == bomb.bombStrength;

    }

    @Override
    public int hashCode() {
        int result = initialPosition;
        result = 31 * result + bombStrength;
        return result;
    }
}
