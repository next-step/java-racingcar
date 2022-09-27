package domain;

import view.InputView;
import view.ResultView;

public class RacingCarGame {

    public static void main(String[] args) {

        final RacingCars racingCars = RacingCars.from(InputView.carCount());
        final RacingAttempt racingAttempt = RacingAttempt.from(InputView.playCount());
        ResultView.resultTitle();
        final RacingScore racingScore = RacingScore.getInstance();
        raceStart(racingAttempt, racingCars, racingScore);
        ResultView.resultPrint(racingScore);
    }

    private static void raceStart(final RacingAttempt racingAttempt, final RacingCars racingCars, final RacingScore racingScore) {

        while (racingAttempt.isAttempt()) {
            racingAttempt.nextPlay(racingCars);
            racingScore.save(racingCars);
        }
    }
}
