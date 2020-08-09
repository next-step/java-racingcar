package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = inputView.scanRacingGameInfo();

        if (racingGame.isAvailableGame()) {
            RacingResult racingResult = racingGame.progress();

            ResultView.print(racingResult);
        }
    }
}
