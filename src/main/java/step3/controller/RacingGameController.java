package step3.controller;

import step3.model.MovableStrategy;
import step3.service.RacingGameService;
import step3.view.InputView;
import step3.view.ResultView;

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
