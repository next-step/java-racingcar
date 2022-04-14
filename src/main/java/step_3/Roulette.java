package step_3;

import java.util.Random;

public class Roulette {

    private final static int MAX_ROULETTE_SCORE = 10;
    private final static Random roulette = new Random();

    private Roulette() {
    }

    public static int spin() {
        return roulette.nextInt(MAX_ROULETTE_SCORE);
    }
}
