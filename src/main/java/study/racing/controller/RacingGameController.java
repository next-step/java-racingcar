package study.racing.controller;

import java.util.List;

import study.racing.domain.Name;
import study.racing.domain.result.GameResults;
import study.racing.service.RacingGameService;
import study.racing.view.InputView;
import study.racing.view.ResultView;

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
