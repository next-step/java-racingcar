package controller;

import domain.Car;
import domain.Cars;
import domain.RacingGame;
import strategy.RandomMovableStrategy;
import ui.InputView;
import ui.ResultView;

import java.util.*;

public class RacingGameController {
    private static final String NAME_DELIMITER = ",";

    public static void main(String[] args) {
        String names = InputView.getNames();
        int tryCount = InputView.getTryCount();

        Cars cars = new Cars(createCars(names));
        RandomMovableStrategy randomMovableStrategy = new RandomMovableStrategy();
        RacingGame racingGame = new RacingGame(randomMovableStrategy);
        ResultView.printStartMessage();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame(cars);
            ResultView.printCurrentLocation(cars);
        }

        ResultView.printWinners(cars.getWinners());
    }

    static List<Car> createCars(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : Arrays.asList(names.split(NAME_DELIMITER))) {
            cars.add(new Car(name));
        }
        return Collections.unmodifiableList(cars);
    }
}
