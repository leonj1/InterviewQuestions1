package com.commonbond.problem2.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bomb meta data
 */
public class Bomb {
    private static int LEFT = -1;
    private static int RIGHT = 1;

    private int initialPosition;
    private int bombStrength;
    private boolean exploded = false;

    public Bomb(int initialPosition, int bombStrength) {
        this.initialPosition = initialPosition;
        this.bombStrength = bombStrength;
    }

    public int getInitialPosition() {
        return initialPosition;
    }

    /**
     * Only the bomb should be able to determine what its shockwaves should be,
     * this is why this factory method exists.
     * @return      a list of Shockwave objects based on this bomb object
     */
    public List<Shockwave> generateShockWaves() {
        List<Shockwave> shockwaves = new ArrayList<Shockwave>();

        // if this bomb exploded already then do not generate any more shockwaves
        if (this.exploded) {
            return shockwaves;
        }

        this.exploded = true;

        return new ArrayList<Shockwave>(Arrays.asList(
                new Shockwave(this.initialPosition, LEFT, this.bombStrength),
                new Shockwave(this.initialPosition, RIGHT, this.bombStrength)
        ));
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
