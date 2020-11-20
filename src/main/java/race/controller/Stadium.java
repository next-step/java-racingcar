package race.controller;

import race.domain.RaceGame;
import race.domain.RandomEngine;
import race.view.InputView;
import race.view.OutputView;

public class Stadium {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        outputView.showScoreBoard(
                RaceGame.fromEngineFactoryAndCarNamesAndIterations(
                        RandomEngine::new,
                        inputView.readCarNames(),
                        inputView.readNumberIterations()
                ).play()
        );
    }
}
