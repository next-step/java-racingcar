package racing_game.util;

import java.util.Random;

public class Roulette {

    private static final int MAX_ROULETTE_SCORE = 10;
    private static final Random ROULETTE = new Random();

    private Roulette() {
    }

    public static int spin() {
        return ROULETTE.nextInt(MAX_ROULETTE_SCORE);
    }
}
