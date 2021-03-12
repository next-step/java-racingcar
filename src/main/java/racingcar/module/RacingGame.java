package racingcar.module;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private RacingRound racingRound;

    public RacingRound startGame(Cars cars, int tryNum) {
        racingRound = new RacingRound();
        for (int num = 0; num < tryNum; num++) {
            cars.playCarGame();
            racingRound.insertResult(cars, num);
        }

        return racingRound;
    }

}
