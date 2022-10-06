package racingGame.factory;

import racingGame.RacingGame;
import racingGame.RacingGameDefault;
import racingGame.racingRule.RacingRule;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public class RacingGameDefaultFactory extends RacingGameFactory {
    @Override
    public RacingGame createRacingGame() {
        return new RacingGameDefault(new InputView(), new ResultView());
    }
}
