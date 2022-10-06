package racingcar;

import racingcar.ui.InputView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {

        List<String> carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(carNames, tryCount);
        racingCarGame.play();

    }
}
