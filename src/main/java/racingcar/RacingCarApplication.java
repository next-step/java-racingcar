package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.RaceHistory;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarController racingCarController = RacingCarController.createFromUserInput();
        RaceHistory raceHistory = racingCarController.run(new RandomMoveStrategy());
        ResultView.printRaceResult(raceHistory);
    }
}
