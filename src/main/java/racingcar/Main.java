package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.domain.TryCount;
import racingcar.domain.carMover.NumberBasedCarMover;
import racingcar.domain.carMover.RandomNumberBasedCarMover;

public class Main {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.inputCarNames());
        TryCount tryCount = new TryCount(InputView.inputTryCount());
        RacingCarGame racingCarGame = new RacingCarGame(tryCount, cars);
        NumberBasedCarMover carMover = new RandomNumberBasedCarMover();
        racingCarGame.startGame(tryCount, cars, carMover);
    }
}
