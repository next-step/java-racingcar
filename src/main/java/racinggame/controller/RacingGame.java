package racinggame.controller;

import racinggame.domain.Car;
import racinggame.domain.Name;
import racinggame.domain.RandomMoveStrategy;
import racinggame.domain.WinnerCalculator;
import racinggame.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    String[] carNames;
    int numOfTrial;
    List<Car> cars;

    public RacingGame(String[] carNames, int numOfTrial) {
        this.carNames = carNames;
        this.numOfTrial = numOfTrial;
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(new Name(name)));
        }
    }

    public void race() {
        for (int i = 0; i < numOfTrial; i++) {
            moveCars(cars);
            ResultView.printRaceResult(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
            car.move(randomMoveStrategy);
        }
    }

    public List<Car> getWinners() {
        return WinnerCalculator.getWinners(cars);
    }
}
