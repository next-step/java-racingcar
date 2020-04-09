package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        List<Car> roundResult = new ArrayList<>();

        while (!racingGame.isRaceEnd()) {
            roundResult = racingGame.race();
            ResultView.printRoundResult(roundResult);
        }

        ResultView.printWinner(Winners.findWinners(roundResult));
    }
}
