package racingcar;

import java.util.ArrayList;
import java.util.List;

import utils.RandomUtils;

public class RacingCar {

    private static final String MOVE_SYMBOL = "-";
    private int distance;

    public void moveIfMovable() {
        if (isMovable()) {
            move();
        }
    }

    // visible for testing
    void move() {
        this.distance++;
    }

    private boolean isMovable() {
        return RandomUtils.random(0, 9) >= 4;
    }

    public String display() {
        return MOVE_SYMBOL.repeat(distance);
    }

    public static List<RacingCar> createRacingCars(int carCount) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }

        return racingCars;
    }

}
