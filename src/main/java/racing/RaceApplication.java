package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

public class RaceApplication {

    public static void main(String[] args) {
        String[] names = InputView.inputParticipationCars();
        int roundCount = InputView.inputNumberOfAttempt();

        RacingGame racingGame = new RacingGame(roundCount, names);
        racingGame.startRacing();
        RacingWinner racingWinner = new RacingWinner(racingGame);
        ResultView.output(racingGame, racingWinner);
    }
}
