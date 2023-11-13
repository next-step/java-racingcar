package racing;

import common.StringSpliter;
import racing.controller.RacingGameController;
import racing.domain.CarMoveStrategy;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameApplication {
    public static void main(String[] args) {

        String userNameAnswer = InputView.getUserNameQuestion();
        String[] userNames = StringSpliter.getSplittedString(userNameAnswer);
        int gameCount = InputView.getGameCountQuestion();

        RacingGame racingGame = new RacingGame(userNames, gameCount, new CarMoveStrategy());

        RacingGameController racingGameController = new RacingGameController(racingGame);
        racingGameController.repeatRace();

        ResultView.printWinnerNoticeView(racingGame);

    }
}
