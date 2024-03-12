package race.domain;

import race.RaceRule;

public class Car {

    private String mileage = "";

    public String getMileage() {
        return this.mileage;
    }

    public void go(int numberOfAttempts, int randomNumber) {
        if (numberOfAttempts > 0) {
            if (isFitRaceRule(randomNumber)) {
                this.mileage += "-";
            }
        } else {
            this.mileage = "-";
        }
    }

    private static boolean isFitRaceRule(int randomNumber) {
        return new RaceRule(new RaceRule(() ->
                randomNumber
        )).generate() >= 4;
    }

}
