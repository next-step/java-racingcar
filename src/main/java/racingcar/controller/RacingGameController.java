package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceResults;
import racingcar.model.RacingGame;
import racingcar.model.RandomStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Cars cars = new Cars(createCars(inputView.inputCarNames()));
        RacingGame racingGame = new RacingGame(cars, inputView.inputTryCount(),
            new RandomStrategy());
        RaceResults raceResults = racingGame.startRace();
        outputView.printResult(raceResults);
        outputView.printWinner(raceResults.findWinners());
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
