package racingcar;

import racingcar.rule.MinimumRule;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputStringView;
import racingcar.view.ResultView;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(
                new InputStringView(),
                new ResultView(),
                new MinimumRule(4, new RandomNumberGenerator(9))
        );
        racingCarGame.start();
        racingCarGame.raceResult();
    }
}
