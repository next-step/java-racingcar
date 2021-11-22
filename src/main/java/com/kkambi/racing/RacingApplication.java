package com.kkambi.racing;

import com.kkambi.racing.domain.Car;
import com.kkambi.racing.domain.Cars;
import com.kkambi.racing.strategy.MovingStrategy;
import com.kkambi.racing.strategy.RandomMovingStrategy;
import com.kkambi.racing.view.InputView;
import com.kkambi.racing.view.ResultView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int numberOfAttempts = inputView.getNumberOfTries();

        Cars cars = composeRacingCars(carNames);

        ResultView resultView = new ResultView();
        resultView.printPhrase();

        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        for (int times = 1; times <= numberOfAttempts; times++) {
            cars.tryToMoveCars(randomMovingStrategy);
            resultView.printInformation(cars.getCars());
        }

        resultView.printWinners(cars.chooseWinners());
    }

    private static Cars composeRacingCars(String[] carNames) {
        return new Cars(
                Arrays.stream(carNames)
                        .map(carName -> new Car(0, carName))
                        .collect(Collectors.toList())
        );
    }
}
