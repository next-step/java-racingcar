package race.controller;

import race.domain.Race;
import race.domain.RaceInput;
import race.view.InputView;
import race.view.ResultView;

import java.util.List;

public class RaceController {
    public static void startRace() {
        RaceInput raceInput = InputView.getRaceInput();
        ResultView.printResultTitle();

        List<String> winners = Race.start(raceInput);
        ResultView.printWinnerMessage(winners);
    }
}
