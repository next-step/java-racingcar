package racingCar.model;

import racingCar.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private int distance;

    private RacingCar() {}

    private RacingCar(int distance) {
        this.distance = distance;
    }

    public static RacingCar create() {
        return new RacingCar();
    }

    public static List<RacingCar> createMulti(int count) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            racingCars.add(create());
        }

        return racingCars;
    }

    public static RacingCar createWithDistance(int distance) {
        return new RacingCar(distance);
    }

    public int distance() {
        return distance;
    }

    private boolean canMove() {
        return RandomUtil.isRandomNumberUnder10GreaterThanOrEqual4();
    }

    private void move() {
        distance++;
    }

    public void race() {
        if (canMove()) {
            move();
        }
    }
}
