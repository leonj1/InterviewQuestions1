package com.commonbond.problem2;

import com.commonbond.problem2.models.Bomb;

import java.util.ArrayList;
import java.util.List;

/**
 * Show shock waves of bomb explosion
 */
public class SolutionTwo {
    public static void main(String[] args) {

    }

    public static String[] explode(String bombs, int force) {
        List<Bomb> bombList = new ArrayList();

        // get bomb positions
        String[] bombPositions = bombs.split("");
        for(int i = 0; i < bombPositions.length; i++) {
            if (bombPositions[i] == "B") {
                bombList.add(new Bomb(i, force));
            }
        }

        // explode the bomb - Time starts now

        // perform while loop until returned String is all dots (i.e. no bombs or shockwaves

        // TODO Fix this!
        return new String[]{};
    }
}
