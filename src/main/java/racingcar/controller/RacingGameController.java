package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGameController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<Car> cars = createCars(inputView.inputCarNames());
        int lastRound = inputView.inputLastRound();
        RacingGame racingGame = new RacingGame(cars, lastRound);

        IntStream.range(0, lastRound)
                .forEach(i -> {
                    racingGame.play();
                    resultView.showResult(racingGame.getCars());
                });
        resultView.showWinners(racingGame.getWinners());
    }

    static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        carNames.forEach((String name) -> cars.add(new Car(name)));
        return cars;
    }
}
