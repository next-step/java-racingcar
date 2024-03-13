package race.domain;

import race.RaceRule;

import java.util.Random;

public class Car {

    private String mileage = "-";
    private static final int END_BOUND = 10;
    private static final Random RANDOM = new Random();

    public String getMileage() {
        return this.mileage;
    }

    public void go(int numberOfAttempts) {
        if (numberOfAttempts > 0) {
            if (isFitRaceRule(RANDOM.nextInt(END_BOUND))) {
                this.mileage += "-";
            }
        }
    }

    private boolean isFitRaceRule(int randomNumber) {
        return new RaceRule(new RaceRule(() ->
                randomNumber
        )).generate() >= 4;
    }

}
