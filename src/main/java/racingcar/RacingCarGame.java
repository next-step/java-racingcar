package racingcar;

import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarGame {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Racing racing = new Racing();

        List<Car> cars = racing.ready(InputView.inputCarCount());

        racing.game(cars, InputView.inputGameCount());
    }

}