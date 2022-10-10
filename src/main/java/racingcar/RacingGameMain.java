package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameCondition;
import racingcar.domain.RacingGameFactory;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameMain {

    public static void main(String[] args) {
        RacingGameCondition condition = InputView.inputRacingCarGameCondition();
        RacingGame game = RacingGameFactory.make(new RandomMovingStrategy(), condition);
        game.run();
        ResultView.printRacingGameResult(game);
    }
}
