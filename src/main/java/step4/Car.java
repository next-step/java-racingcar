package step4;

import java.util.Random;

public class Car {
    private String name;
    private String racingResult;

    private Random random = new Random();

    private static final int RANDOM_RANGE = 10;
    private static final int FORWARD_STATUS_VALUE = 4;
    private static final String FORWARD_VALUE = "-";
    private static final String STOP_VALUE = "";

    public Car(String name, String racingResult) {
        this.name = name;
        this.racingResult = racingResult;
    }

    public String getName() {
        return name;
    }

    public String getRacingResult() {
        return racingResult;
    }

    public void move() {
        racingResult += forwardStatus(getRandomNumber());
    }

    public int getRandomNumber() {
        return random.nextInt(RANDOM_RANGE);
    }

    public String forwardStatus(int randomNumber) {
        if (randomNumber < FORWARD_STATUS_VALUE) {
            return STOP_VALUE;
        }
        return FORWARD_VALUE;
    }

}
