package study.step5.try3.domain;

import study.step5.try3.util.RandomNumber;
import study.step5.try3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final NumberOfAttempts numberOfAttempts;

    public CarRacingGame(Cars cars, NumberOfAttempts numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public static CarRacingGame of(String carNames, int numberOfAttempts) {
        return new CarRacingGame(Cars.of(init(carNames)), NumberOfAttempts.of(String.valueOf(numberOfAttempts)));
    }

    private static List<Car> init(String carNames) {
        List<Car> carList = new ArrayList<>();
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            carList.add(Car.of(CarName.of(carName).getCarName(), 0));
        }
        return carList;
    }

    public ResultView start() {
        int numberOfAttempts = this.numberOfAttempts.getNumber();
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
