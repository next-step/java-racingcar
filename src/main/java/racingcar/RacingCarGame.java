package racingcar;

import racingcar.model.Garage;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGame {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Garage.createCars(InputView.inputCarCount());

        Racing.game(InputView.inputAttemptCount());

        ResultView.print();
    }

}