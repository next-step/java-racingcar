package study.carracing.controller;

import study.carracing.domain.Racing;
import study.carracing.ui.InputView;
import study.carracing.ui.ResultView;
import study.carracing.util.Validator;

public class RacingController {

    private final InputView inputView;
    private final ResultView resultView;
    private static final String NAMES_DELIMITER = ",";

    public RacingController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        final String carsName = inputView.inputCarsName();
        Validator.validateCarName(carsName);
        final int tryCount = inputView.inputTryCount();
        Validator.validateNumber(tryCount);

        resultView.outputTitle();
        Racing racing = new Racing();
        racing.start(carsName.split(NAMES_DELIMITER), tryCount);
        resultView.outputResult(racing.racingHistory());
        resultView.outputResultAndComment(racing.winners());
    }
}
