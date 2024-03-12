package racingcar.controller;

import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.model.RaceResult;
import racingcar.model.RandomNumberStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Race {

    private final InputView inputView;
    private final ResultView resultView;

    public Race(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        resultView.printCarAmount();
        CarNames carNames = inputView.inputCarName();
        resultView.printTryNumber();
        int tryNumber = inputView.inputNumber();

        Cars cars = new Cars(carAmount);

        RaceResult raceResult = cars.tryMove(tryNumber, new RandomNumberStrategy());
        resultView.printResultNotice();
        resultView.printTryResult(raceResult);
    }
}
