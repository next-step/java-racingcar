package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

public class RacingGame {

    public void race() {
        int participationCars = InputView.inputParticipationCars();
        int numberOfAttempt = InputView.inputNumberOfAttempt();

        Cars cars = new Cars(participationCars);
        ResultView.output(numberOfAttempt, cars);
    }
}
