package com.racing;

import com.racing.domain.Car;
import com.racing.domain.Cars;
import com.racing.ui.InputView;
import com.racing.ui.ResultView;
import com.racing.utils.CarHelper;
import com.racing.utils.RacingHelper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.getCarName();
        int tryNumber = InputView.getTryNumber();

        List<String> validCarNames = CarHelper.splitCarName(carNames);

        Cars cars = createCars(validCarNames);

        runRace(cars, tryNumber);

        List<Car> winners = CarHelper.determineWinners(cars);
        ResultView.printWinners(winners);
    }

    private static Cars createCars(List<String> carNames) {
        Cars cars = new Cars();

        for (String carName : carNames) {
            cars.addCars(new Car(0, carName));
        }

        return cars;
    }

    private static void runRace(Cars cars, int tryNumber) {
        ResultView.printStartMessage();
        for (int i = 0; i < tryNumber; i++) {
            moveAllCars(cars);
            ResultView.printRoundResult(i + 1, cars.getCarList());
        }
    }

    private static void moveAllCars(Cars cars) {
        RacingHelper racingHelper = new RacingHelper();

        for (Car car : cars.getCarList()) {
            car.move(racingHelper.shouldMove());
        }
    }
}