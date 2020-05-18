package racingcar;

import racingcar.race.Dice;

import java.util.Random;

public class RacingDice implements Dice {
    public static int RACING_MAX_BOUND = 10;

    int bound;

    private RacingDice(int bound) {
        this.bound = bound;
    }

    public static RacingDice newInstance() {
        return new RacingDice(RACING_MAX_BOUND);
    }

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(bound);
    }

}
