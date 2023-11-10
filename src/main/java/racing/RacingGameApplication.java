package racing;

import common.StringSpliter;
import racing.domain.CarMoveStrategy;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.Random;

public class RacingGameApplication {

    public static void main(String[] args) {
        String userNameAnswer = InputView.getUserNameQuestion();
        String[] userNames = StringSpliter.getSplittedString(userNameAnswer);
        int gameCount = InputView.getGameCountQuestion();

        RacingGame racingGame = new RacingGame(userNames, gameCount, new CarMoveStrategy(new Random()));

        while (racingGame.isProgress()) {
            racingGame.race();
            ResultView.printProgressView(racingGame);
        }

        ResultView.printWinnerNoticeView(racingGame);

    }
}
