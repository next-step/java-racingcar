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
        String carNames = InputView.InputCarNames();
        int StageCount = InputView.InputStageCount();

        ResultView.viewResultPhrase();
        ResultView.viewResult(racingGameService.play(carNames, StageCount));
    }
}
