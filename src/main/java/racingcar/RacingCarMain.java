package racingcar;

import racingcar.rule.MinimumRule;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(
                new InputView(),
                new ResultView(),
                new MinimumRule(4, new RandomNumberGenerator(9))
        );

        racingCarGame.start();
    }
}
