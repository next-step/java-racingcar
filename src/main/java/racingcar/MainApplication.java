package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int moveCount = InputView.inputMoveCount();
        InputView.closeScanner();
        List<Car> winners = RacingCar.play(carNames, moveCount);
        ResultView.printWinners(winners);
    }
}
