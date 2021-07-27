package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class MainApplication {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int moveCount = InputView.inputMoveCount();
        InputView.closeScanner();
        String winners = RacingCar.play(carNames, moveCount);
        ResultView.printWinners(winners);
    }
}
