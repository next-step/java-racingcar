package racing;

import racing.domain.*;
import racing.domain.strategy.RandomMovingStrategy;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarGameApplication {

    public static void main(String[] args) {

        final RacingCars racingCars = RacingCars.from(CarName.from(InputView.carName()));
        final RacingAttempt racingAttempt = new RacingAttempt(InputView.playCount());
        final RacingScore racingScore = RacingScore.init();

        ResultView.titlePrint();
        play(racingAttempt, racingCars, racingScore);
        ResultView.resultPrint(racingScore);

        final WinnerRacingCars winnerRacingCars = new WinnerRacingCars(racingCars.score());
        winnerRacingCars.win();
        ResultView.winnerPrint(winnerRacingCars);
    }

    private static void play(final RacingAttempt racingAttempt, final RacingCars racingCars, final RacingScore racingScore) {

        while (racingAttempt.canAttempt()) {
            racingAttempt.attempt();
            racingCars.enter(racingScore, new RandomMovingStrategy());
        }
    }
}