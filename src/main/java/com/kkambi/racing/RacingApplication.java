package com.kkambi.racing;

import com.kkambi.racing.domain.Car;
import com.kkambi.racing.domain.Cars;
import com.kkambi.racing.domain.Winners;
import com.kkambi.racing.strategy.RandomMovingStrategy;
import com.kkambi.racing.view.InputView;
import com.kkambi.racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int numberOfAttempts = inputView.getNumberOfTries();

        Cars cars = composeRacingCars(carNames);

        ResultView resultView = new ResultView();
        resultView.printPhrase();

        for (int times = 1; times <= numberOfAttempts; times++) {
            cars.tryToMoveCars();
            resultView.printInformation(cars.getCars());
        }
        Winners winners = new Winners();
        winners.chooseWinners(cars.getCars());
        resultView.printWinners(winners);
    }

    private static Cars composeRacingCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(0, carName);
            car.setMovingStrategy(new RandomMovingStrategy());
            cars.add(car);
        }
        return new Cars(cars);
    }
}
