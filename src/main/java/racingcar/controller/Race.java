package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RaceResult;
import racingcar.model.RandomNumberStrategy;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Race {

    private final InputView inputView;
    private final ResultView resultView;
    private final Validator validator;

    public Race(InputView inputView, ResultView resultView, Validator validator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.validator = validator;
    }

    public void start() {
        resultView.printCarAmount();
        int carAmount = getCarAmount();
        resultView.printTryNumber();
        int tryNumber = getTryNumber();

        Cars cars = new Cars(carAmount);

        RaceResult raceResult = cars.tryMove(tryNumber, new RandomNumberStrategy());
        resultView.printResultNotice();
        resultView.printTryResult(raceResult);
    }

    private Integer getTryNumber() {
        String tryNumber = inputView.inputTryNumber();
        validator.numericCheck(tryNumber);
        validator.nullCheck(tryNumber);
        return Integer.parseInt(tryNumber);
    }

    private Integer getCarAmount() {
        String carAmount = inputView.inputCarAmount();
        validator.nullCheck(carAmount);
        validator.numericCheck(carAmount);
        return Integer.parseInt(carAmount);
    }
}
