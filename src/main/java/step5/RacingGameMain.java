package step5;

import step4.view.InputView;
import step5.model.RacingGame;

import java.util.Arrays;

public class RacingGameMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.runInputView();

        RacingGame raceGame = new RacingGame(Arrays.asList(inputView.getNamesOfCars()));

        for (int loop = 0; loop < inputView.getTrialCounts(); loop++) {
            raceGame.playGame();
        }

    }
}
