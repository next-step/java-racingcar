package step4;

import step4.model.RacingGame;
import step4.view.InputView;

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
