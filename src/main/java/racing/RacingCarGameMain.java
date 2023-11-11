package racing;

import racing.controller.GameSetup;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class RacingCarGameMain {

    public static void main (String[] arg) {
        OutputView.requestCarNames();
        List<String> carNames = InputView.getCarNames();

        OutputView.requestRoundNum();
        int numOfRound = InputView.getNumberOfRound();
        OutputView.showResult();

        GameSetup gameSetup = new GameSetup(numOfRound, carNames);

        for (int i = 0; i < numOfRound; i++) {
            gameSetup.moveCar();

            OutputView.showRound(i);
            OutputView.display(gameSetup.cars());
        }
    }
}
