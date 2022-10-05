package racingGame.factory;

import racingGame.RacingGame;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public abstract class RacingGameFactory<racingRule> {

    abstract RacingGame createRacingGame(InputView inputView, ResultView resultView);
}
