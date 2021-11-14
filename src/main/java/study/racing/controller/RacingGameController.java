package study.racing.controller;

import java.util.List;

import study.racing.model.Result;
import study.racing.service.RacingGameService;
import study.racing.ui.InputView;
import study.racing.ui.ResultView;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void start() {
        List<String> carNames = InputView.acceptCarNames();
        int tryCount = InputView.acceptTryCount();

        List<Result> results = racingGameService.race(carNames, tryCount);

        ResultView.printResult(results);
    }
}
