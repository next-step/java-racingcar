package step3;

import step3.domain.*;
import step3.view.RaceConditionInputView;
import step3.view.RaceResultView;

import java.util.List;

public class RaceController {

    public static void main(String[] args) {
        List<String> carNames = RaceConditionInputView.readCarNames();
        int raceRound = RaceConditionInputView.readRaceRound();
        Race race = new Race(RacingCars.create(carNames), RaceRound.of(raceRound), new CarRandomMovement());
        RaceHistory history = race.start();
        RaceResultView.display(history);
    }
}
