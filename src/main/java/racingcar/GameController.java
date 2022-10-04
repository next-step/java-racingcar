package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCarGameFactory;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.MovingStrategyType;
import racingcar.view.ResultView;

import static racingcar.strategy.MovingStrategyType.RANDOM;

public class GameController {

    public static final MovingStrategy MOVING_STRATEGY = MovingStrategyType.getStrategy(RANDOM);

    public static void main(String[] args) {
        RacingCarGame racingCarGame = RacingCarGameFactory.getInstance();

        ResultView.printTitle();

        while (!racingCarGame.isEnd()) {
            racingCarGame.play(MOVING_STRATEGY);
            ResultView.printPlayResults(racingCarGame.getPlayResults());
        }

        ResultView.printWinners(RacingCarGame.findWinners(racingCarGame.getPlayResults()));
    }

}
