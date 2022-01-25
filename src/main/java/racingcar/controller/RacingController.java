package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.ResultView;

public class RacingController {

    private final RacingService racingService;
    private final ResultView resultView;

    public RacingController(final RacingService racingService, final ResultView resultView) {
        this.racingService = racingService;
        this.resultView = resultView;
    }

    public void startRacing() {
        racingService.drive();
    }

    public void carsCurrentStatements() {
        resultView.announceCurrentStatement(racingService.notifyCurrentStatement());
    }

    public String finishRacing() {
        return resultView.announceWinner(racingService.judgeWinners());
    }

}
