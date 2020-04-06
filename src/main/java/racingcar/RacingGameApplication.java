package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        while (!racingGame.isRaceEnd()) {
            System.out.println("===== RACE =====");
            List<Car> race = racingGame.race();
            ResultView.printRoundResult(race);
        }

        ResultView.printWinner(racingGame.getWinners());
    }
}
