package com.commonbond.problem2.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Keep track of initial Bomb positions and shockwaves
 */
public class Space {
    // track the initial location of the bombs in this space
    private List<Bomb> bombs = new ArrayList();

    // track the shockwave locations as they move through space; remove once out of bounds
    private List<Shockwave> shockwaves = new ArrayList();

    // register bomb force to know where the shockwaves should be at any specified time slice
    private int bombForce;

    public Space(List<Bomb> bombs, int bombForce) {
        this.bombs = bombs;
        this.bombForce = bombForce;
    }

    /**
     * Starting with time slice 1, figure out where the shockwaves should be.
     * As time increments the shockwaves should move at speed "force" and direction left/right
     * Once returned String is all dots, then the shockwaves have passed and we're done.
     * @param time
     * @return
     */
    public String scenarioAtTime(int time) {
        // TODO implement + add unit tests

        return "";
    }
}
