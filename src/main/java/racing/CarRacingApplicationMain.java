package racing;

import racing.domain.Race;
import racing.ui.InputView;
import racing.ui.OutputView;

public class CarRacingApplicationMain {
    public static void main(String[] args) {
        Race race = InputView.createRace();
        race.play();
        OutputView.showResult(race);
    }
}
