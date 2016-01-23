package com.jose.commonbond1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Print string containing letters in alphabet that are missing from input
 */
public class App {
    private static final Map<String, Integer> baseAlphabet;
    static {
        baseAlphabet = new HashMap<String, Integer>();
        baseAlphabet.put("a", 1);
        baseAlphabet.put("b", 1);
        baseAlphabet.put("c", 1);
        baseAlphabet.put("d", 1);
        baseAlphabet.put("e", 1);
        baseAlphabet.put("f", 1);
        baseAlphabet.put("g", 1);
        baseAlphabet.put("h", 1);
        baseAlphabet.put("h", 1);
        baseAlphabet.put("i", 1);
        baseAlphabet.put("j", 1);
        baseAlphabet.put("k", 1);
        baseAlphabet.put("l", 1);
        baseAlphabet.put("m", 1);
        baseAlphabet.put("n", 1);
        baseAlphabet.put("o", 1);
        baseAlphabet.put("p", 1);
        baseAlphabet.put("q", 1);
        baseAlphabet.put("r", 1);
        baseAlphabet.put("s", 1);
        baseAlphabet.put("t", 1);
        baseAlphabet.put("u", 1);
        baseAlphabet.put("v", 1);
        baseAlphabet.put("w", 1);
        baseAlphabet.put("x", 1);
        baseAlphabet.put("y", 1);
        baseAlphabet.put("z", 1);
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println(listMissingLetters(args[0]));
        }
    }

    /**
     * Find any letters in the alphabet that's missing from the input string
     * @param s     the input string
     * @return      string of any missing letters
     */
    public static String listMissingLetters(String s) {
        // copying map since we're going to edit its count
        Map<String, Integer> alphabet = new HashMap<String, Integer>(App.baseAlphabet);

        String[] asArray = s.toLowerCase().split("");

        // get unique letters in the query string
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(asArray));

        // increment count of found letters in alphabet.
        for(String letter : set) {
            if(alphabet.containsKey(letter)) {
                Integer newValue = alphabet.get(letter) + 1;
                alphabet.put(letter, newValue);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String letter : alphabet.keySet()) {
            // any letter that was not found will remain to have a count of 1
            if (alphabet.get(letter) == 1) {
                sb.append(String.valueOf(letter));
            }
        }

        return sb.toString();
    }
}
