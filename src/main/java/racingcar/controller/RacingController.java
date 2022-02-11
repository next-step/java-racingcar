package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarView;

public class RacingController {

    public void start() {
        List<String> carNames = RacingCarInput.inputCarName();
        int endRaceCount = RacingCarInput.inputRaceCount();

        RacingGame racingGame = new RacingGame(
            Cars.of(carNames), endRaceCount, new RandomMoveStrategy());

        List<Cars> racingLogs = racingGame.race();

        RacingCarView.printRacing(racingLogs);
        RacingCarView.printWinner(racingGame.getCars());
    }
}
