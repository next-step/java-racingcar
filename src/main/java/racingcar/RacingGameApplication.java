package racingcar;

import racingcar.ui.RacingGameParameterInputView;
import racingcar.vo.RacingGameParameter;

public class RacingGameApplication {
    public static void main(String[] args) {
        RacingGameApplication.start();
    }

    public static void start() {
        RacingGameParameterInputView inputView = new RacingGameParameterInputView();
        RacingGameParameter parameter = inputView.readRacingGameParameter();

        RacingGame racingGame = new RacingGame(parameter.getCarNames());
        racingGame.start(parameter.getTryCount());
    }
}