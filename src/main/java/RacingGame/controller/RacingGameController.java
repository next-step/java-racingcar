package RacingGame.controller;

import RacingGame.model.MovableStrategy;
import RacingGame.service.RacingGameService;
import RacingGame.view.InputView;
import RacingGame.view.ResultView;

public class RacingGameController {
    private final RacingGameService racingGameService;

    public RacingGameController(MovableStrategy movableStrategy) {
        this.racingGameService = new RacingGameService(movableStrategy);
    }

    public void play() {
        int carCount = InputView.InputCarCount();
        int StageCount = InputView.InputStageCount();

        ResultView.viewResultPhrase();
        ResultView.viewResult(racingGameService.play(carCount, StageCount));
    }
}
