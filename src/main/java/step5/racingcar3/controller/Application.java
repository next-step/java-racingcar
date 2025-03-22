package step5.racingcar3.controller;

import java.util.ArrayList;
import java.util.List;
import step5.racingcar3.domain.Car;
import step5.racingcar3.domain.CarEngine;
import step5.racingcar3.domain.CarList;
import step5.racingcar3.domain.CarName;
import step5.racingcar3.domain.PositiveNumber;
import step5.racingcar3.domain.RacingGame;
import step5.racingcar3.view.InputView;
import step5.racingcar3.view.ResultView;

public class Application {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();

    public static CarList initCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(new CarName(carName), new CarEngine()));
        }
        return new CarList(cars);
    }

    public static PositiveNumber initNumberOfRounds(int numberOfRounds) {
        return new PositiveNumber(numberOfRounds);
    }

    public void run() {
        List<String> inputCarNames = inputView.getCarNames();
        int inputNumberOfRounds = inputView.getNumberOfRounds();

        CarList cars = initCars(inputCarNames);
        PositiveNumber numberOfRounds = initNumberOfRounds(inputNumberOfRounds);

        resultView.showResultTitle();
        for (int i = 0; i < numberOfRounds.value(); i++) {
            RacingGame racingGame = new RacingGame(cars);
            racingGame.start();
            racingGame.end();

            resultView.showCarListResult(cars);
        }

        CarList winners = cars.winners();
        resultView.showWinnersResult(winners);
    }

}
