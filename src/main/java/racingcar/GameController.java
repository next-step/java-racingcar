package racingcar;

import racingcar.domain.PlayResult;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCarGameFactory;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.MovingStrategyType;
import racingcar.view.ResultView;

import java.util.List;

import static racingcar.strategy.MovingStrategyType.RANDOM;

public class GameController {

    public static final MovingStrategy MOVING_STRATEGY = MovingStrategyType.getStrategy(RANDOM);

    public static void main(String[] args) {
        RacingCarGame racingCarGame = RacingCarGameFactory.getInstance();

        ResultView.printTitle();

        List<PlayResult> playResults = null;
        while (!racingCarGame.isEnd()) {
            racingCarGame.play(MOVING_STRATEGY);
            playResults = racingCarGame.getPlayResults();

            ResultView.printPlayResults(playResults);
        }

        ResultView.printWinners(RacingCarGame.findWinners(playResults));
    }

}
