package racingGame;

import racingGame.factory.RacingGameDefaultFactory;
import racingGame.racingRule.RacingRuleDefault;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        RacingGameDefaultFactory racingGameDefaultFactory = new RacingGameDefaultFactory();
        RacingGame racingGame = racingGameDefaultFactory.createRacingGame();
        racingGame.play();
    }
}
