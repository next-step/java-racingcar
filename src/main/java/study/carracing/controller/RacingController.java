package study.carracing.controller;

import study.carracing.domain.Racing;
import study.carracing.ui.InputView;
import study.carracing.ui.ResultView;
import study.carracing.util.Validator;

public class RacingController {

    private InputView inputView;
    private ResultView resultView;

    public RacingController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public Racing start() {
        final int carCount = Validator.validateInput(inputView.inputCarCount());
        final int tryCount = Validator.validateInput(inputView.inputTryCount());

        resultView.outputTitle();
        Racing racing = new Racing();
        racing.start(carCount, tryCount);
        resultView.outputResult(racing.getRacingCars());

        return racing;
    }

}
