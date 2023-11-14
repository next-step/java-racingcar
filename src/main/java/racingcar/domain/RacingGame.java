package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    public static final int RANDOM_BOUND = 10;
    private final int round;
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(String carNames, int round) {
        this.round = round;
        initCars(carNames.split(","));

    }

    private void initCars(String[] carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public List<List<Car>> race() {
        List<List<Car>> racingResult = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            racingResult.add(moveCar());
        }
        return racingResult;
    }

    private List<Car> moveCar() {
        List<Car> roundResult = new ArrayList<>();
        for (Car car : this.cars) {
            car.moveForward(getRandomValue());
            roundResult.add(car);
        }
        return roundResult;
    }

    private int getRandomValue() {
        return new Random().nextInt(RANDOM_BOUND);
    }
}
