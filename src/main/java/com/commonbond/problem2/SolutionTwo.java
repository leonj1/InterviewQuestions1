package com.commonbond.problem2;

import com.commonbond.problem2.models.Bomb;
import com.commonbond.problem2.models.Space;

import java.util.ArrayList;
import java.util.List;

/**
 * Show shock waves of bomb explosion
 * Give it a string where "." indicates empty position and "B" indicates a bomb.
 * Provide the "force" of the bomb (how many spaces its shockwave should be).
 * The program will display the shockwaves caused by each bomb.
 */
public class SolutionTwo {
    public static void main(String[] args) {

        String scenario = "..B...B.BB.B..";
        int force = 1;

        String[] result = explode(scenario, force);

        for(String scene : result) {
            System.out.println(scene);
        }
    }

    /**
     * Method which initiates the explosion of all bombs and shows the played out scenario of shockwaves.
     * @param bombs     the string representation of where the bombs are placed on a string
     * @param force     the speed of the shockwave for that bomb
     * @return          a string array of each scene as the shockwaves travel until no longer in view
     */
    public static String[] explode(String bombs, int force) {
        List<Bomb> bombList = new ArrayList();

        // get bomb positions
        String[] bombPositions = bombs.split("");
        for(int i = 0; i < bombPositions.length; i++) {
            if ("B".equals(bombPositions[i])) {
                bombList.add(new Bomb(i, force));
            }
        }

        Space space = new Space(bombList, bombs.length());
        List<String> scenes = space.watchItBurn();

        String[] result = new String[scenes.size()];
        for(int i=0; i<scenes.size(); i++) {
            result[i] = scenes.get(i);
        }

        return result;
    }
}
