package com.commonbond.problem2.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Keep track of initial Bomb positions and shockwaves
 */
public class Space {
    // track the initial location of the bombs in this space
    private List<Bomb> bombs = new ArrayList();

    // the full width of the space in 2D
    private int width;

    // track the shockwave locations as they move through space; remove once out of bounds
    private List<Shockwave> shockwaves = new ArrayList();

    // essentially the board where bombs or shockwaves get displayed
    private String[] spaces;

    private boolean ignited = false;

    /**
     * Space constructor with required fields
     * @param bombs
     * @param width
     */
    public Space(List<Bomb> bombs, int width) {
        this.bombs = bombs;
        this.width = width;
        this.spaces = new String[width];
        this.resetSpaces();
    }

    /**
     * This plays out the scenarios to see what happens once the bombs are ignited
     * @return      array of Strings of each scenario showing the bombs and shockwaves
     */
    public List<String> watchItBurn() {
        List<String> scene = new ArrayList<String>();
        scene.add(this.getScene());

        this.ignite();

        String nextScene = null;
        while(!isShockwavesGone(nextScene)) {
            updateShockwaves();
            nextScene = this.getScene();
            scene.add(nextScene);
        }

        return scene;
    }

    /**
     * Generate a String representation of the "space" with either Bombs or Shockwaves.
     * If two shockwaves in opposite directions occupy a space then render "X"
     * @return
     */
    private String getScene() {
        if (this.ignited) {
            this.resetSpaces();
            String currentSpaceElement = null;
            for(Shockwave wave : this.shockwaves) {
                int wavePosition = wave.getPosition();
                currentSpaceElement = this.spaces[wavePosition];
                if (("<".equals(currentSpaceElement) && wave.getDirection().equals(">")) ||
                (">".equals(currentSpaceElement) && wave.getDirection().equals("<"))) {
                    // being here means a shockwave was already placed here
                    this.spaces[wavePosition] = "X";
                } else {
                    if (wave.getDirection().equals(Shockwave.LEFT)) {
                        this.spaces[wavePosition] = "<";
                    } else if(wave.getDirection().equals(Shockwave.RIGHT)) {
                        this.spaces[wavePosition] = ">";
                    }
                }
            }
        } else {
            for(Bomb bomb : this.bombs) {
                this.spaces[bomb.getInitialPosition()] = "B";
            }
        }

        return Arrays.toString(this.spaces).replace("[", "").replace("]", "").replace(",", "").replaceAll("\\s+","");
    }

    /**
     * Let's us know if there are any more shockwaves on the board
     * @param space     the space being checked to see if there are any shockwaves
     * @return          boolean of whether or not there are any shockwaves on the "space" board
     */
    private boolean isShockwavesGone(String space) {
        if(space == null) {
            return false;
        }

        String[] spaceAsArray = space.split("");
        Set<String> spaceUniqueValues = new HashSet<String>(Arrays.asList(spaceAsArray));
        if (spaceUniqueValues.size() > 1) {
            return false;
        }

        if (!spaceUniqueValues.contains(".")) {
            return false;
        }

        return true;
    }

    /**
     * Helper method to reset the "space" to dots for re-use.
     */
    private void resetSpaces() {
        for(int i = 0; i < this.spaces.length; i++) {
            this.spaces[i] = ".";
        }
    }

    /**
     *  Here is where we go from worrying about bombs to worrying about their shockwaves
     */
    private void ignite() {
        this.ignited = true;
        this.resetSpaces();

        for(Bomb bomb : bombs) {
            this.addShockwaves(bomb.generateShockWaves());
        }
    }

    /**
     * A safe way to add shockwaves since we do not want to track those that are out of bounds
     * @param shockwaves    the waves being considered to be tracked
     */
    private void addShockwaves(List<Shockwave> shockwaves) {
        for(Shockwave wave : shockwaves) {
            int wavePosition = wave.getPosition();
            if (wave.getPosition() >= 0 && wavePosition <= this.width) {
                this.shockwaves.add(wave);
            }
        }
    }

    /**
     * Update the shockwave position by one unit of time.
     * If their new positions are out of bounds then remove the shockwave from list to stop tracking it
     */
    private void updateShockwaves() {
        Iterator<Shockwave> i = this.shockwaves.iterator();
        while (i.hasNext()) {
            Shockwave wave = i.next(); // must be called before you can call i.remove()
            int newPosition = wave.move();
            if (!inBounds(newPosition)) {
                i.remove();
            }
        }
    }

    /**
     * Determine if the provided position is within the bounds of the space.
     * This helps us determine if we should keep tracking the object at that position or not.
     * @param position      the position being checked
     * @return              boolean of whether or not the position is within the "space" range
     */
    private boolean inBounds(int position) {
        return position >= 0 && position < width;
    }
}
