package step3;

import step3.domain.Race;
import step3.view.InputRaceCondition;
import step3.view.RaceConditionInputView;

public class RaceController {

    public static void main(String[] args) {
        InputRaceCondition raceCondition = RaceConditionInputView.display();
        Race race = new Race(raceCondition.carCount, raceCondition.raceRound);
        race.start();
    }
}
