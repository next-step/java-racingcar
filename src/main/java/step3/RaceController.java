package step3;

import step3.domain.Race;
import step3.domain.RacingCars;
import step3.view.RaceConditionInputView;

import java.util.List;

public class RaceController {

    public static void main(String[] args) {
        List<String> carNames = RaceConditionInputView.readCarNames();
        int raceRound = RaceConditionInputView.readRaceRound();
        Race race = new Race(RacingCars.create(carNames), raceRound);
        race.start();
    }
}
