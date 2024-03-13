package race.domain;

import race.RaceRule;

import java.util.Random;

public class Car {

    private static final Random RANDOM = new Random();
    private static final int STANDARD_BOUND = 4;
    private static final int END_BOUND = 10;
    private int position;

    public int getPosition() {
        return this.position;
    }

    public void go(int numberOfAttempts) {
            if (numberOfAttempts > 0 && isFitRaceRule(RANDOM.nextInt(END_BOUND))) {
                this.position += 1;
            }
    }

    private boolean isFitRaceRule(int randomNumber) {
        return new RaceRule(new RaceRule(() ->
                randomNumber
        )).generate() >= STANDARD_BOUND;
    }

}
