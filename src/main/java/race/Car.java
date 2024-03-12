package race;

import java.util.Random;

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
            this.mileage += "-";
        }
    }

    private static boolean isFitRaceRule(int randomNumber) {
        RaceRule raceRule = new RaceRule(() ->
            randomNumber
        );
        return raceRule.generate() >= 4;
    }

}
