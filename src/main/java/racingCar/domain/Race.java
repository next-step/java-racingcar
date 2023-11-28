package racingCar.domain;

import java.util.List;
import java.util.Random;

public class Race {
    private static final int MAX_RANDOM_NUMBER = 10;
    private Cars racingCars;

    private final Random random = new Random();

    public Race(String carNames) {
        this.racingCars = new Cars(carNames);
    }

    public Cars cars() {
        return this.racingCars;
    }

    public void singleRace() {
        for (Car car : this.racingCars.allCar()) {
            car.moveForward(randomNumber());
        }
    }

    private int randomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER);
    }

    public List<Car> winners() {
        return this.racingCars.fastestCars();
    }
}
