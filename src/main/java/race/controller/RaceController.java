package race.controller;

import race.domain.RaceInput;
import race.domain.RacingCars;
import race.view.InputView;
import race.view.ResultView;

import java.util.List;

public class RaceController {
    public static void startRace() {
        RaceInput raceInput = InputView.getRaceInput();
        ResultView.printResultTitle();

        RacingCars cars = RacingCars.from(raceInput.carNames());
        for (int round = 0; round < raceInput.gameCount(); round++) {
            ResultView.printRoundTitle(round);
            cars.startRound();
            ResultView.printRoundResult(cars);
        }

        List<String> winners = cars.findWinners();
        ResultView.printWinnerMessage(winners);
    }
}
