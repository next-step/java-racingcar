package racingcar;

import racingcar.ui.RacingCarInputView;
import racingcar.ui.RacingCarResultView;

public class RacingCarMain {
    public static void main(String[] args) {
        new RacingCarGame(
            RacingCarInputView.getInstance(),
            RacingCarResultView.getInstance(),
            DefaultRacingCarGameWinnerStrategy.getInstance()).start();
    }
}
