package racingcar.contoller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarController {
    private final MovingStrategy movingStrategy;

    public RacingCarController(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void run() {
        List<String> carNames = InputView.carNamesScan();
        int round = InputView.roundScan();
        Race race = new Race(Cars.create(carNames));

        ResultView.printStartMessage();

        for (int i = 0; i < round; i++) {
            ResultView.printRace(race.playRace(new RandomMovingStrategy()));
        }
        ResultView.printResult(race.findWinners());
    }

}
