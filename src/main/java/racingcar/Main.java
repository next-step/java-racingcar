package racingcar;

import racingcar.domain.InputCarCount;
import racingcar.domain.InputRoundCount;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Main {

    public static void main(String[] args) {
        InputCarCount carCount = InputView.viewInputCarCount();
        InputRoundCount roundCount = InputView.viewInputRoundCount();

        RacingGame racingGame = new RacingGame(carCount, roundCount);
        racingGame.play();
    }
}
