package racingGame;

import racingGame.View.InputView;
import racingGame.View.ResultView;


public class RacingGame {

    private GameSetting gameSetting;

    private static final int INITIAL_ROUND = 0;
    private static final String GAME_START_MESSAGE = "결과";

    public RacingGame() {
        this.gameSetting = InputView.createInstance().setUpGame();
    }

    public void run() {

        int currentRound = INITIAL_ROUND;
        ResultView resultView = ResultView.of(gameSetting);

        System.out.println(GAME_START_MESSAGE);

        for (; !gameSetting.gameFinished(currentRound); currentRound += 1) {
            resultView.processRound();
            resultView.printStatus();
        }

    }

}
