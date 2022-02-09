package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarView;

public class RacingController {

    public void start(){
        List<String> carNames = RacingCarInput.getCarName();
        int endRaceCount = RacingCarInput.getRaceCount();

        RacingGame racingGame = initRacingGame(carNames, endRaceCount);

        List<Cars> racingLogs = racingGame.race();

        RacingCarView.printRacing(racingLogs);
        RacingCarView.printWinner(racingGame.getCars());
    }

    private RacingGame initRacingGame(List<String> carNames, int endRaceCount) {
        return new RacingGame(
            Cars.of(carNames), endRaceCount, new RandomMoveStrategy());
    }
}
