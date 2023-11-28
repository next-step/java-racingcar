package racingCar.domain;

import java.util.Random;

public class RandomNumber {
    public static final int FORWARD_BOUNDARY_VALUE = 3;
    public static final int RANDOM_LIMIT_VALUE = 10;

    int randomNumber;

    public RandomNumber() {
        this.randomNumber = new Random().nextInt(RANDOM_LIMIT_VALUE);
    }

    public RandomNumber(int number) {
        this.randomNumber = number;
    }

    public boolean isMovable(){
        return randomNumber > FORWARD_BOUNDARY_VALUE;
    }
}
