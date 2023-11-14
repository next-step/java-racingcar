package racingcar.model;

import java.util.Random;

public class RacingCar {
    private static final String ERR_NAME_LENGTH = "Names longer than 5 characters are not allowed.";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int THRESHOLD_NUMBER = 4;
    private static final int START_POSITION = 0;
    private static final int STEP = 1;

    private int position;
    private String name;

    public RacingCar(String name) {
        // validation
        validateCarName(name);

        // setting
        this.name = name;
        this.position = START_POSITION;
    }

    private void validateCarName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERR_NAME_LENGTH);
        }
    }


    public void moveOrStop(int value) {
        if (value >= THRESHOLD_NUMBER) {
            // move
            this.position += STEP;
        }
    }


    public int biggerPosition(int position) {
        if (this.position > position) {
            return this.position;
        }
        return position;
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }


    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
