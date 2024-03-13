package race.domain;

import race.RaceRule;

import java.util.Random;

public class Car {

    private static final Random RANDOM = new Random();
    private static final int STANDARD_BOUND = 4;
    private static final int END_BOUND = 10;
    private String mileage = "-";

    public String getMileage() {
        return this.mileage;
    }

    public void go(int numberOfAttempts) {
            if (numberOfAttempts > 0 && isFitRaceRule(RANDOM.nextInt(END_BOUND))) {
                this.mileage += "-";
            }
    }

    private boolean isFitRaceRule(int randomNumber) {
        return new RaceRule(new RaceRule(() ->
                randomNumber
        )).generate() >= STANDARD_BOUND;
    }

}
