package racingGame;

import racingGame.view.InputView;
import racingGame.view.ResultView;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.execute();

        RacingGame racingGame = new RacingGame();
        racingGame.setParticipateCount(inputView.getParticipateCount());
        racingGame.setGameCount(inputView.getGameCount());

        List<Positions> start = racingGame.start();
        ResultView resultView = new ResultView(start);
        resultView.print();
    }
}
