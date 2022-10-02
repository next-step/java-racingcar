package racing;

import racing.domain.*;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarGameApplication {

    public static void main(String[] args) {

        final RacingCars racingCars = RacingCars.from(CarNames.from(InputView.carName()));
        final RacingAttempt racingAttempt = new RacingAttempt(InputView.playCount());
        final RacingScore racingScore = RacingScore.getInstance();

        ResultView.titlePrint();
        racingCars.play(racingAttempt, racingScore);
        ResultView.resultPrint(racingScore);

        final WinnerRacingCars winnerRacingCars = new WinnerRacingCars(racingCars.score());
        winnerRacingCars.win();
        ResultView.winnerPrint(winnerRacingCars);
    }
}