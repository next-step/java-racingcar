package step5;

import step5.domain.RacingGame;
import step5.dto.Result;
import step5.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        Result result = Result.from(racingGame.startGame());

        ResultView.printGameResult(result);
    }
}
