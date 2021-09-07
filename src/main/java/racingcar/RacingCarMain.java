package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingResults;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {

        RacingGame racingGame = new RacingGame();
        String carsName = InputView.inputCarName();
        String[] cars = carsName.split(",");
        int attempt = InputView.inputAttempt();

        List<RacingResults> results = racingGame.startRace(attempt, cars);
        ResultView.showRacing(results);

        int lastResultIndex = results.size() -1;
        RacingResults lastResult = results.get(lastResultIndex);

        List<String> winners = lastResult.getWinners();
        ResultView.showWinner(winners);
    }

}
