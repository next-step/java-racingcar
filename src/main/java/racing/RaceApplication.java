package racing;

import racing.controller.RacingController;
import racing.ui.InputView;

public class RaceApplication {

    public static void main(String[] args) {
        String[] names = InputView.inputParticipationCars();
        int roundCount = InputView.inputNumberOfAttempt();

        RacingController racingController = new RacingController();
        racingController.race(names, roundCount);
    }
}