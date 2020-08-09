package racingcar;

import controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApp {
    public static void main(String[] args) {

        String racingCarName = InputView.getInputCarName();
        String racingRound = InputView.getRacingRound();

        RacingController racingController = new RacingController(racingCarName, racingRound);
        racingController.startRace();

        ResultView resultView = new ResultView(racingController.getRacingResults());
        resultView.displayRacingResult();
        resultView.displayWinnersResult();
    }
}
