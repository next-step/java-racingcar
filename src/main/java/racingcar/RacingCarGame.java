package racingcar;

import racingcar.entity.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGame {
    public RacingCarGame() {}

    public void race(RacingCars racingCars, int tryNumber, MoveStrategy moveStrategy) {
        ResultView.printResultFirstLine();
        for (int i = 0; i < tryNumber; i++) {
            raceOneStep(racingCars, moveStrategy);
            ResultView.printRacingCarsPosition(racingCars);
        }
    }

    public void raceOneStep(RacingCars racingCars, MoveStrategy moveStrategy) {
        racingCars.moveIfMovableAll(moveStrategy);

    }

    public int findMaxPosition(RacingCars racingCars) {
        return racingCars.findMaxPosition();

    }

    public List<String> pickWinners(RacingCars racingCars, int winnerRecord) {
        return racingCars.pickWinners(winnerRecord);
    }
}
