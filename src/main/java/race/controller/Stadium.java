package race.controller;

import race.domain.Cars;
import race.domain.LapScores;
import race.domain.RaceGame;
import race.domain.RandomEngine;
import race.view.InputView;
import race.view.OutputView;

import java.util.List;

public class Stadium {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        List<LapScores> scores = new RaceGame(new Cars(RandomEngine::new, inputView.readCarNames()), inputView.readNumberIterations()).play();
        outputView.showScoreBoard(scores);
    }
}
