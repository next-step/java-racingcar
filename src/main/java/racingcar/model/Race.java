package racingcar.model;

import racingcar.domain.Cars;

import java.util.Random;

public class Race {
    private static final int RANDOM_BOUND = 10;
    private static final int RACE_THRESHOLD = 4;

    private final Random random;

    public Race() {
        this.random = new Random();
    }

    public void roundRace(Cars cars) {
        cars.getCarList().forEach(car -> {
            int randomValue = random.nextInt(RANDOM_BOUND);
            if (randomValue > RACE_THRESHOLD) car.move();
        });
    }

}
