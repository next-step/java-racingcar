package study.carracing.controller;

import study.carracing.domain.Racing;
import study.carracing.ui.InputView;
import study.carracing.ui.ResultView;
import study.carracing.util.Validator;

public class RacingController {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        final String[] carsName = Validator.validateCarName(inputView.inputCarsName());
        final int tryCount = Validator.validateNumber(inputView.inputTryCount());

        resultView.outputTitle();
        Racing racing = new Racing();
        racing.start(carsName, tryCount);
        resultView.outputResult(racing.getRacingCars());
        resultView.outputResult(racing.getWinners());
    }
}
