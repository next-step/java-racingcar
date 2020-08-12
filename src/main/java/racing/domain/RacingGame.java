package racing.domain;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class RacingGame {

    public void start() {
        final List<String> carNames = InputView.getNameByRacingCars();
        final int roundCnt = InputView.getNumberOfAttempt();

        final RacingCars racingCars = RacingCars.of(carNames);
        ResultView.printRacingGameResult();
        for (int i = 0; i < roundCnt; i++) {
            ResultView.printLocationsByCars(racingCars.raceOfCars(racingCars.getCars()));
        }
        ResultView.printRacingWinners(racingCars);
    }
}
