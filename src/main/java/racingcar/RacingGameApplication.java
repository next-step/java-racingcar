package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingResult;
import racingcar.domain.RandomNumberMover;
import racingcar.view.InputView;
import racingcar.view.ResultView;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.of(InputView.getCarNames()
                ,InputView.getAttemptNumber());

        RacingResult racingResult = racingGame.progress(new RandomNumberMover());
        ResultView.print(racingResult);
    }
}
