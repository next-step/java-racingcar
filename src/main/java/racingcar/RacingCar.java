package racingcar;

import java.util.Random;

public class RacingCar {

    private static final Random rand = new Random();
    private static final String ERR_NAME_LENGTH = "Names longer than 5 characters are not allowed.";
    private static final int NAME_MAX_LENGTH = 5;

    private int location = 1;
    private String name;

    public RacingCar(String name) {
        validateCarName(name);
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

    public void validateCarName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new RuntimeException(ERR_NAME_LENGTH);
        }
    }
}
