package racingcar.controller;

import racingcar.domain.Car;
import racingcar.model.CarsProgress;

import java.util.List;
import java.util.Random;

public class RacingCarProgressService {
    public static final int RANDOM_NUMBER_BOUND = 10;

    private CarsProgress carsProgress;
    private Random random = new Random();

    public void createCars(int numberOfCars) {
        carsProgress = new CarsProgress(numberOfCars);
    }

    public List<Car> getCarsList() {
        return carsProgress.getCarsList();
    }

    public int getRandomValue() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public void changeDistanceByCar(Car car, int determinationValue) {
        carsProgress.changeDistanceByCar(car, determinationValue);
    }
}
