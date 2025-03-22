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

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> inputCarNames = inputView.getCarNames();
        int inputNumberOfRounds = inputView.getNumberOfRounds();

        CarList carList = initCars(inputCarNames);
        PositiveNumber numberOfRounds = initNumberOfRounds(inputNumberOfRounds);

        ResultView resultView = new ResultView();
        resultView.showResultTitle();
        RacingGame racingGame = null;
        for (int i = 0; i < numberOfRounds.value(); i++) {
            racingGame = new RacingGame(carList);
            racingGame.start();
            racingGame.end();

            resultView.showCarListResult(carList);
        }

        assert racingGame != null;
        CarList winners = racingGame.winners();
        resultView.showWinnersResult(winners);
    }

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

}
