package race.controller;

import race.domain.Cars;
import race.domain.RaceGame;
import race.domain.RandomEngine;
import race.view.InputView;
import race.view.OutputView;

public class Stadium {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        new RaceGame(new Cars(RandomEngine::new, inputView.readCarNames()),
                inputView.readNumberIterations(),
                new OutputView()).play();
    }
}
