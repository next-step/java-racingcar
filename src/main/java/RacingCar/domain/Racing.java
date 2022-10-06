package RacingCar.domain;

import java.util.*;

public class Racing {
    private static int RANDOM_NUMBER_RANGE = 10;

    private int round;

    public Racing(int round) {
        this.round = round;
    }

    public void round(Number randomNumber, List<Car> cars) {
        for (Car car : cars) {
            int random = randomNumber.random(RANDOM_NUMBER_RANGE);

            car.move(random);
        }
    }

    public int getRound() {
        return round;
    }
}
