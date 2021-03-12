package racingcar.module;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class RacingGame {

    public void startGame(Cars cars, int tryNum) {
        for (int num = 0; num < tryNum; num++) {
            cars.playCarGame();
        }

    }
}
