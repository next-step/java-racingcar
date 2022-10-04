package racing;

import racing.domain.MovingRule;
import racing.domain.Race;
import racing.domain.RandomRule;
import racing.ui.Form;
import racing.ui.InputView;
import racing.ui.OutputView;

public class CarRacingApplicationMain {
    public static void main(String[] args) {
        MovingRule movingRule = new RandomRule();
        Form form = InputView.createForm();
        Race race = new Race(form.getNameOfCars(), form.getNumberOfPlays(), movingRule);
        race.play();
        OutputView.showResult(race);
    }
}
