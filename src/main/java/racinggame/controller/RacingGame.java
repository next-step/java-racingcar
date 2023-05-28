package racinggame.controller;

import racinggame.domain.Name;
import racinggame.domain.RandomMoveStrategy;
import racinggame.domain.WinnerCalculator;
import racinggame.domain.Car;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int numOfTrial = InputView.getNumOfTrial();

        List <Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(new Name(name)));
        }

        ResultView.printResultMessage();
        for (int i = 0; i < numOfTrial; i++) {
            moveCars(cars);
            ResultView.printRaceResult(cars);
        }

        List<Car> winners = WinnerCalculator.getWinners(cars);
        ResultView.printWinner(winners);
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
            car.move(randomMoveStrategy);
        }
    }
}
