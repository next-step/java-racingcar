package racingcar;

import racingcar.entity.RacingCar;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameMain {
    public static void main(String[] args) {
        List<RacingCar> racingCars = new ArrayList<>();
        String[] carNames = InputView.requestCarNames();
        int tryNumber = InputView.requestTryNumber();
        RacingCarGame racingCarGame = new RacingCarGame(racingCars, carNames);
        racingCarGame.race(racingCars, tryNumber, new RandomMoveStrategy());
        int winnerRecord = racingCarGame.findMaxPosition(racingCars);
        List<String> winners = racingCarGame.pickWinners(racingCars, winnerRecord);
        ResultView.printWinners(winners);
    }
}
