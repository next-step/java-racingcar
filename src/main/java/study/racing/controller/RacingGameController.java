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
        int carCount = InputView.acceptCarCount();
        int tryCount = InputView.acceptTryCount();

        List<Result> results = racingGameService.race(carCount, tryCount);

        ResultView.printResult(results);
    }
}
