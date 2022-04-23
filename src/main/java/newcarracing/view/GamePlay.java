package newcarracing.view;

import newcarracing.domain.RacingGame;
import newcarracing.domain.RandomRuleCondition;

public class GamePlay {
    public static void main(String[] args) throws CloneNotSupportedException {
        String[] carNames = InputView.inputCarsWithName();
        int tryCount = InputView.inputTryCount();
        RacingGame racingGame = RacingGame.makeRacingGame(new RandomRuleCondition());
        ResultView.printGameResult(racingGame.play(carNames, tryCount));
    }
}