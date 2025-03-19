package racing;

import racing.domain.RacingCarGame;
import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;
import racing.config.GameConfig;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarGamePlayer {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingCarGamePlayer() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void start() {
        try {
            GameConfig gameConfig = inputView.promptForGameConfig();
            NumberGenerator numberGenerator = new RandomNumberGenerator();

            RacingCarGame racingGame = new RacingCarGame(gameConfig, numberGenerator);
            racingGame.startRace();

            resultView.displayRaceResults(racingGame);
        } finally {
            inputView.close();
        }
    }

    public static void main(String[] args) {
        new RacingCarGamePlayer().start();
    }
}
