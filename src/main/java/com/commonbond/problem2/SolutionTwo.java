package com.commonbond.problem2;

import com.commonbond.problem2.models.Bomb;
import com.commonbond.problem2.models.Space;

import java.util.ArrayList;
import java.util.List;

/**
 * Show shock waves of bomb explosion
 */
public class SolutionTwo {
    public static void main(String[] args) {

        String scenario = "..B...B.BB.B..";
        String[] result = explode(scenario, 1);

        for(String scene : result) {
            System.out.println(scene);
        }
    }

    public static String[] explode(String bombs, int force) {
        List<Bomb> bombList = new ArrayList();

        // get bomb positions
        String[] bombPositions = bombs.split("");
        for(int i = 0; i < bombPositions.length; i++) {
            if ("B".equals(bombPositions[i])) {
                bombList.add(new Bomb(i, force));
            }
        }

        Space space = new Space(bombList, force, bombs.length());
        List<String> scenes = space.watchItBurn();

        String[] result = new String[scenes.size()];
        for(int i=0; i<scenes.size(); i++) {
            result[i] = scenes.get(i);
        }

        return result;
    }
}
