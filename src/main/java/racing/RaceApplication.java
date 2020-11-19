package racing;

import racing.domain.RacingGame;
import racing.domain.RacingRound;
import racing.domain.RacingWinner;
import racing.ui.InputView;
import racing.ui.ResultView;

public class RaceApplication {

    public static void main(String[] args) {
        String[] names = InputView.inputParticipationCars();
        int roundCount = InputView.inputNumberOfAttempt();

        RacingGame racingGame = new RacingGame(roundCount, names);
        RacingRound racingRound = racingGame.startRacing();
        RacingWinner racingWinner = new RacingWinner(racingRound);
        ResultView.output(racingRound, racingWinner);
    }
}
