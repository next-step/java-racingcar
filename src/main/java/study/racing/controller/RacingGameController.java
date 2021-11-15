package study.racing.controller;

import java.util.List;

import study.racing.model.Name;
import study.racing.model.result.GameResults;
import study.racing.service.RacingGameService;
import study.racing.ui.InputView;
import study.racing.ui.ResultView;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void start() {
        List<Name> carNames = InputView.acceptCarNames();
        int tryCount = InputView.acceptTryCount();

        GameResults gameResults = racingGameService.race(carNames, tryCount);

        ResultView.printResult(gameResults);
    }
}
