package racing.controller;

import java.util.List;
import racing.domain.RacingGame;
import racing.domain.TryNumber;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingController {

    public RacingController() {
    }

    public void start() {
        try {
            final List<String> names = InputView.getCarNames();
            final RacingGame racingGame = RacingGame.registerCars(names);

            final TryNumber tryNumber = InputView.getTryNumber();
            racingGame.race(tryNumber);

            OutputView.printGameResult(racingGame.raceResult());
            OutputView.printWinners(racingGame.decideWinners());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }
}
