package racing;

import racing.controller.GameSetup;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingCarGameMain {

    public static void main (String[] arg) {
        OutputView.requestCarNum();
        int numOfCar = InputView.getNumberOfCar();

        OutputView.requestRoundNum();
        int numOfRound = InputView.getNumberOfRound();
        OutputView.showResult();

        GameSetup gameSetup = new GameSetup(numOfCar, numOfRound);

        for (int i = 0; i < numOfRound; i++) {
            gameSetup.moveCar();

            OutputView.showRound(i);
            OutputView.display(gameSetup.cars());
        }
    }
}
