package race.entry;

import race.logic.Cars;
import race.logic.RaceGame;
import race.logic.RandomEngine;
import race.ui.InputView;
import race.ui.OutputView;

public class Stadium {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        new RaceGame(new Cars(RandomEngine::new, inputView.readCarNames()),
                inputView.readNumberIterations(),
                new OutputView()).play();
    }
}
