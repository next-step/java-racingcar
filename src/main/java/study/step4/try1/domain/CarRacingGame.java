package study.step4.try1.domain;

import study.step4.try1.utils.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private Cars cars;
    private int numberOfAttempts;

    public CarRacingGame(Cars cars, int numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public static CarRacingGame of(String carNameWithComma, int numberOfAttempts) {
        return new CarRacingGame(new Cars(carNameWithComma), numberOfAttempts);
    }

    public List<Car> start() {
        List<Car> carList = this.cars.getCars();
        List<Car> resultList = new ArrayList<>();
        for (int round = 1; round <= numberOfAttempts; round++) {
            progressGame(carList, resultList);
        }
        return resultList;
    }

    private void progressGame(List<Car> carList, List<Car> resultList) {
        for (Car car : carList) {
            resultList.add(car.move(RandomNumber.create()));
        }
        resultList.add(null);
    }
}
