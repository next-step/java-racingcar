package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

public class RaceApplication {

    public static void main(String[] args) {
        int participationCars = InputView.inputParticipationCars();
        int numberOfAttempt = InputView.inputNumberOfAttempt();

        RacingRound racingRound = new RacingRound(participationCars, numberOfAttempt);
        ResultView.output(racingRound);
    }
}
