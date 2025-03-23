package racing;

import racing.domain.RacingCarGame;
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

            RacingCarGame racingGame = new RacingCarGame(gameConfig);
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
