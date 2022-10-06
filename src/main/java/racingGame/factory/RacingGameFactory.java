package racingGame.factory;

import racingGame.RacingGame;
import racingGame.RacingGameDefault;
import racingGame.racingRule.RacingRule;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public abstract class RacingGameFactory {


    abstract RacingGame createRacingGame();
}
