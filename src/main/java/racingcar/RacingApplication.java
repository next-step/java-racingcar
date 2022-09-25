package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingApplication {
    public static void main(String[] args) {
        new RacingGameController(new InputView(), new ResultView()).run();
    }
}
