package race;

import race.controller.RaceController;
import race.view.InputView;
import race.view.ResultView;

import java.util.Random;

public class RaceMain {

    public static void main(String[] args) {
        RaceController race = new RaceController(new Random(), new InputView(), new ResultView());
        race.run();
    }
}
