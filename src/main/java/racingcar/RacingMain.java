package racingcar;

import racingcar.domains.RacingCars;
import racingcar.domains.RacingResultsAll;
import racingcar.views.InputView;
import racingcar.views.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        InputView.startInput();

        String carNames = InputView.getRacingCarNames();
        int roundNumTotal = InputView.getRoundNumTotal();

        RacingGame racingGame = new RacingGame();
        RacingCars racingCars = racingGame.initiateCars(carNames);

        RacingResultsAll racingResultsAll = racingGame.startRace(racingCars, roundNumTotal);

        ResultView.showRaceResult(racingResultsAll, racingCars);
    }
}

