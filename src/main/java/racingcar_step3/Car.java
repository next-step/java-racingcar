package racingcar_step3;

import java.util.Random;

public class Car {

    private static int getRandom() {
        Random rand = new Random();
        return rand.nextInt(CarRacingConstants.RANDOM_RANGE);
    }

    public static int setForward(int randomNumber) {
        return randomNumber < CarRacingConstants.MOVE_POSSIBLE_VALUE ?
                CarRacingConstants.STOP_VALUE : CarRacingConstants.FORWARD_VALUE;
    }

    public static int move(int totalDistance) {
        return totalDistance + setForward(getRandom());
    }
}
