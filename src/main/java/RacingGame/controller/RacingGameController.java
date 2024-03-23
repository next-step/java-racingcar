package RacingGame.controller;

import RacingGame.model.MovableStrategy;
import RacingGame.model.RacingResult;
import RacingGame.service.RacingGameService;
import RacingGame.view.InputView;
import RacingGame.view.ResultView;

public class RacingGameController {
    private final RacingGameService racingGameService;

    public RacingGameController(MovableStrategy movableStrategy) {
        this.racingGameService = new RacingGameService(movableStrategy);
    }

    public void play() {
        String carNames = InputView.InputCarNames();
        int stageCount = InputView.InputStageCount();

        ResultView.viewResultPhrase();
        RacingResult racingResult = racingGameService.play(carNames, stageCount);

        ResultView.showProgress(racingResult.getHistories());
        ResultView.showWinners(racingResult.winners());
    }
}
