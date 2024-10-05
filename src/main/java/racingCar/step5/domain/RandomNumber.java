package racingCar.step5.domain;

import java.util.Random;

public class RandomNumber {
    private static final int NUMBER_LIMIT = 10;
    private static final Random RANDOM = new Random();

    private int number;

    public RandomNumber() {

    }

    public RandomNumber(int number) {
        this.number = number;
    }

    public int generate() {
        if (number == 0) {
            number = RANDOM.nextInt(NUMBER_LIMIT);
        }
        return number;
    }
}
