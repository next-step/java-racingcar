package study.step4.try2.domain;

import study.step4.try2.view.ResultView;
import study.step4.try2.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final NumberOfAttemps numberOfAttempts;

    public CarRacingGame(String[] carNamesArray, NumberOfAttemps numberOfAttempts) {
        this.cars = Cars.of(init(carNamesArray));
        this.numberOfAttempts = numberOfAttempts;
    }

    private List<Car> init(String[] carNamesArray) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNamesArray) {
            carList.add(Car.of(carName, Position.of(0)));
        }
        return carList;
    }

    public static CarRacingGame of(String[] carNamesArray, int numberOfAttempts) {
        return new CarRacingGame(carNamesArray, NumberOfAttemps.of(String.valueOf(numberOfAttempts)));
    }

    public ResultView start() {
        int numberOfAttempts = this.numberOfAttempts.getNumberOfAttempts();
        for (int round = 0; round < numberOfAttempts; round++) {
            race();
        }
        return ResultView.of(cars, numberOfAttempts);
    }

    private void race() {
        for (Car car : cars.getCars()) {
            car.move(RandomNumber.create());
        }
    }
}
