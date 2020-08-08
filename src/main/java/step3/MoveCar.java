package step3;

import step3.dto.Car;

import java.util.Random;

public class MoveCar {

    private static final int RANDOM_MAXIMUM_BOUND = 10;
    private static final int MOVE_CRITERION_UNDER_4 = 4;

    public static boolean moveCondition(Car car) {
        int randomVal = new Random().nextInt(RANDOM_MAXIMUM_BOUND);

        if(randomVal < MOVE_CRITERION_UNDER_4) return false;

        car.movePosition();
        return true;
    }

}
