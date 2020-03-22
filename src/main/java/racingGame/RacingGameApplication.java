package racingGame;

import racingGame.game.CarForwardRule;
import racingGame.game.RacingGame;
import racingGame.game.RacingGameRule;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.execute();

        RacingGameRule gameRule = new CarForwardRule();
        RacingGame racingGame = new RacingGame(gameRule);
        racingGame.participate(inputView.getParticipates(), inputView.getGameCount());
        racingGame.start();

        ResultView resultView = new ResultView(racingGame.getTotalGameResult());
        resultView.print();
    }
}
