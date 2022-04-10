package racingcar.controller;

import commons.Constant;
import racingcar.domain.Cars;
import racingcar.model.CarsProgress;

import java.util.List;
import java.util.Random;

public class RacingCarProgressService {
    private CarsProgress carsProgress;
    private Random random = new Random();

    public void createCars(int numberOfCars) {
        carsProgress = new CarsProgress(numberOfCars);
    }

    public List<Cars> getCarsList() {
        return carsProgress.getCarsList();
    }

    public int getRandomValue() {
        return random.nextInt(Constant.RANDOM_NUMBER_BOUND);
    }

    public void changeDistanceByCar(Cars cars, int determinationValue) {
        carsProgress.changeDistanceByCar(cars, determinationValue);
    }
}
