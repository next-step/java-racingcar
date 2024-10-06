package race.controller;

import race.domain.Race;
import race.domain.RaceInput;
import race.domain.RaceResult;
import race.view.InputView;
import race.view.ResultView;

public class RaceController {
    public static void startRace() {
        RaceInput raceInput = InputView.getRaceInput();
        ResultView.printResultTitle();

        RaceResult raceResult = Race.start(raceInput);
        ResultView.printRaceResult(raceResult);
    }
}
