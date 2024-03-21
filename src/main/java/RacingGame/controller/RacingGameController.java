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
        int stageCount = InputView.InputStageCount();

        ResultView.viewResultPhrase();
        racingGameService.init(carNames);
        for (int i = 0; i < stageCount; i++) {
            ResultView.stageStatus(racingGameService.play());
        }

        ResultView.showWinners(racingGameService.winners());
    }
}
