package step5;

import step5.view.InputView;
import step5.model.RacingGame;
import step5.streategy.RacingGameMovementStrategy;
import step5.view.OutputView;

import java.util.Arrays;

public class RacingGameMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.runInputView();

        RacingGame raceGame = new RacingGame(Arrays.asList(inputView.getNamesOfCars()));

        OutputView.showBanner();
        for (int loop = 0; loop < inputView.getTrialCounts(); loop++) {
            OutputView.showResultOfGame(raceGame.playGame(new RacingGameMovementStrategy()));
            System.out.println();
        }

        OutputView.printWinnersFromParticipants(raceGame.getWinnerPlayers());
    }
}
