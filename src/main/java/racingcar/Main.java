package racingcar;

import racingcar.domain.input.InputCarCount;
import racingcar.domain.input.InputRoundCount;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Main {

    public static void main(String[] args) {
        InputCarCount carCount = InputView.renderCarCountInputView();
        InputRoundCount roundCount = InputView.renderRoundCountInputView();

        RacingGame racingGame = new RacingGame(carCount, roundCount);
        racingGame.play();
    }
}
