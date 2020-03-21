package racingGame;

import racingGame.view.InputView;
import racingGame.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.execute();

        RacingGame racingGame = new RacingGame();
        racingGame.setParticipateCount(inputView.getParticipateCount());
        racingGame.setGameCount(inputView.getGameCount());

        ResultView resultView = new ResultView(racingGame.start());
        resultView.print();
    }
}
