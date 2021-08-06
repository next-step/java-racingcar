package racingcar;

import racingcar.entity.Name;
import racingcar.entity.RacingCars;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGameMain {
    public static void main(String[] args) {
        RacingCars racingCars = new RacingCars(InputView.requestCarNames());
        int tryNumber = InputView.requestTryNumber();

        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.race(racingCars, tryNumber, new RandomMoveStrategy());

        int winnerRecord = racingCarGame.findMaxPosition(racingCars);
        List<Name> winners = racingCarGame.pickWinners(racingCars, winnerRecord);
        ResultView.printWinners(winners);
    }
}
