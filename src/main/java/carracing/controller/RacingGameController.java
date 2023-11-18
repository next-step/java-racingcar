package carracing.controller;

import carracing.domain.car.Winners;
import carracing.domain.game.MovingStrategy;
import carracing.domain.game.RacingGame;
import carracing.domain.game.WinnerStrategy;
import carracing.view.ResultView;

public class RacingGameController {
    public void start(RacingGame racingGame,
                      MovingStrategy movingStrategy,
                      WinnerStrategy winnerStrategy) {
        for (int i = 0; i < racingGame.tryNumbers(); i++) {
            racingGame.race(movingStrategy);
            ResultView.printMovingResult(racingGame);
        }

        ResultView.printResultPhrase();
        Winners winners = racingGame.winners(winnerStrategy);
        ResultView.printWinners(winners);
    }
}
