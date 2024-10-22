package com.racing.service;

import com.racing.domain.Car;
import com.racing.domain.Cars;
import com.racing.ui.InputView;
import com.racing.ui.ResultView;
import com.racing.utils.CarHelper;
import com.racing.utils.CarMovement;

import java.util.List;

public class RacingService {
    public static void startRacingGame() {
        String carNames = InputView.getCarName();
        int tryNumber = InputView.getTryNumber();

        List<String> validCarNames = CarHelper.splitCarName(carNames);

        Cars cars = initializeRacingCars(validCarNames);

        executeRaceRounds(cars, tryNumber);

        Cars winners =
                cars.determineWinners();
        ResultView.printWinners(winners);
    }

    private static Cars initializeRacingCars(List<String> carNames) {
        Cars cars = new Cars();

        for (String carName : carNames) {
            cars.addCars(new Car(0, carName));
        }

        return cars;
    }

    private static void executeRaceRounds(Cars cars, int tryNumber) {
        ResultView.printStartMessage();
        for (int i = 0; i < tryNumber; i++) {
            advanceAllCars(cars);

            int roundNumber = i + 1;
            ResultView.printRoundResult(roundNumber, cars);
        }
    }

    private static void advanceAllCars(Cars cars) {
        CarMovement carMovement = new CarMovement();

        for (Car car : cars.getItems()) {
            car.move(carMovement.shouldMove());
        }
    }
}
