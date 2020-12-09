package racing.view;

import racing.domain.Cars;
import racing.domain.RaceWinner;

public class OutputView {

    public static void racingResult() {
        RacingResultView.printResultMessage();
    }

    public static void racingStatus(Cars cars) {
        RacingResultView.printRacingStatus(cars);
    }

    public static void racingEnd(RaceWinner raceWinner) {
        RacingResultView.printEndGame(raceWinner);
    }
}
