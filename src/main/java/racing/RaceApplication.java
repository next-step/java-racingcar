package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

public class RaceApplication {

    public static void main(String[] args) {
        int participationCars = InputView.inputParticipationCars();
        int numberOfAttempt = InputView.inputNumberOfAttempt();

        ResultView.raceResult(participationCars ,numberOfAttempt);
    }
}
