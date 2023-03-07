package racingCar;

import java.util.Random;

import static racingCar.RacingCarConfiguration.MAX_RANDOM_VALUE;
import static racingCar.RacingCarConfiguration.LIMIT_RANDOM_VALUE;

public class Car {
    private static final int CAR_STEP_LIMIT = 4;
    private final String name;
    private StringBuilder position = new StringBuilder();
    private Random random = new Random();

    public Car (final String name) {
        this.name = name;
    }

    public void step(final int number) {
        if (number >= CAR_STEP_LIMIT)
            position.append("-");
    }

    public void printPosition() {
        System.out.println(this.name+" : "+position);
    }

    public int myPosition() {
        return position.length();
    }

    public String amIWinner(int maxPosition) {
        if (this.position.length() < maxPosition)
            return null;
        return this.name;
    }
}
