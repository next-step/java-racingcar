package racingcar;

import java.util.Random;

public class RacingCar {

    private static final Random rand = new Random();
    private int location = 1;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }


    public static int getRandomValue() {
        return rand.nextInt(10);
    }

    public void moveOrStop(int value) {
        if (value >= 4) {
            // move
            this.location += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public String getLocationMark() {
        String locationMark = "";
        for (int i = 0; i<this.getLocation(); i++) {
            locationMark += "-";
        }
        return locationMark;
    }
}
