package study.step5;

import study.step5.domain.RacingGame;
import study.step5.domain.RacingGameProgress;
import study.step5.domain.RandomCarMoveCondition;
import study.step5.dto.RacingGameResult;
import study.step5.view.InputView;
import study.step5.view.ResultView;

public class RacingGameLauncher {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputCarNames() , InputView.inputTryTime());
        RacingGameProgress racingGameProgress = new RacingGameProgress(racingGame);
        RacingGameResult racingGameResult = racingGameProgress.runGames(new RandomCarMoveCondition());

        ResultView.racingResultPrint(racingGameResult);
    }
}
