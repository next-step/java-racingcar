package study.step4.domain;

import study.step4.utils.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private Cars cars;
    private int numberOfAttempts;

    public CarRacingGame(Cars cars, int numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<Car> start() {
        List<Car> carList = this.cars.getCars();
        List<Car> resultList = new ArrayList<>();
        for (int round = 1; round <= numberOfAttempts; round++) {
            for (Car car : carList) {
                resultList.add(car.move(RandomNumber.create()));
            }
            resultList.add(null);
        }
        return resultList;
    }
}
