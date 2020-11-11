package study.racingcar;

import study.racingcar.domain.GameConfiguration;
import study.racingcar.domain.RacingGame;
import study.racingcar.domain.RacingGameResult;
import study.racingcar.domain.car.CarSnapshot;
import study.racingcar.domain.racingcars.RacingCarsSnapshot;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

import java.util.List;

/**
 * 도메인 객체와 소통하는 컨트롤러
 */
public class RacingGameController {

    private ResultView resultView = ResultView.getInstance();

    public void startRacingGame() {

        GameConfiguration gameConfiguration = InputView.initGameWithOldEngine();

        RacingGame racingGame = new RacingGame(gameConfiguration);
        RacingGameResult racingGameResult = racingGame.startGame();

        displayGameProgress(racingGameResult.getGameProgressSnapshots());
        displayGameResult(racingGameResult.getWinners());

    }

    private void displayGameProgress(List<RacingCarsSnapshot> gameProgressSnapshots) {
        for (RacingCarsSnapshot racingCarsSnapshot : gameProgressSnapshots) {
            resultView.displayCurrentStatus(racingCarsSnapshot);
        }
    }

    private void displayGameResult(List<CarSnapshot> winners) {
        resultView.displayWinner(winners);
    }

}
