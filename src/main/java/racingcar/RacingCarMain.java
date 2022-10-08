package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {

        List<String> carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(carNames, tryCount);
        racingCarGame.play();

    }
}
