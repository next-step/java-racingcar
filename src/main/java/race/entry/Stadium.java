package race.entry;

import race.logic.Cars;
import race.logic.LapScores;
import race.logic.RandomEngine;
import race.ui.InputView;
import race.ui.OutputView;

import java.util.Optional;

public class Stadium {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        Cars cars = new Cars(RandomEngine::new, inputView.readCarNames());

        LapScores latestScore = null;
        for(int i = 0; i < inputView.readNumberIterations(); ++i) {
            latestScore = cars.lap();
            outputView.showScore(latestScore);
        }
        Optional.ofNullable(latestScore)
                .ifPresent(outputView::showWinner);
    }
}
