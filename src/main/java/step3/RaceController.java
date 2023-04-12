package step3;

import step3.domain.Race;
import step3.domain.RaceCondition;
import step3.view.RaceConditionInputView;

public class RaceController {

    public static void main(String[] args) {
        RaceCondition raceCondition = RaceConditionInputView.display();
        Race race = new Race(raceCondition.carCount, raceCondition.raceRound);
        race.start();
    }
}
