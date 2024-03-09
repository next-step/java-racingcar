package racing.controller;

import racing.service.RacingService;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {
    private static final String CAR_QUESTION = "car";
    private static final String ATTEMPT_QUESTION = "attempt";

    private RacingService racingService;
    private int cars;
    private int attempts;
    private InputView inputView;
    private ResultView resultView;

    public void run() {
        init();
        setValues();
        resultView = racingService.start(cars, attempts);
        resultView.showResult();
    }

    private void init() {
        inputView = new InputView();
        racingService = new RacingService();
    }

    private void setValues() {
        cars = inputView.inputNumber(CAR_QUESTION);
        attempts = inputView.inputNumber(ATTEMPT_QUESTION);
    }

}
