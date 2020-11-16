package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

public class RaceApplication {

    public static void main(String[] args) {
        String[] names = InputView.inputParticipationCars();
        int numberOfAttempt = InputView.inputNumberOfAttempt();

        RacingRound racingRound = new RacingRound(names, numberOfAttempt);
        RacingWinner racingWinner = new RacingWinner(racingRound);
        ResultView.output(racingRound, racingWinner);
    }
}
