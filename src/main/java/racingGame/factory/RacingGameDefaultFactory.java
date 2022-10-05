package racingGame.factory;

import racingGame.RacingGame;
import racingGame.racingRule.RacingRuleDefault;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public class RacingGameDefaultFactory extends RacingGameFactory {
    private RacingRuleDefault racingRuleDefault = new RacingRuleDefault();

    @Override
    public RacingGame createRacingGame(InputView inputView, ResultView resultView) {

        return new RacingGame(inputView, resultView) {
            @Override
            public void play() {
                super.play(racingRuleDefault);
            }
        };
    }
}
