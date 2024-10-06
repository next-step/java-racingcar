package racingcar;

import racingcar.model.Garage;
import racingcar.model.Racing;
import racingcar.view.InputView;

public class RacingCarGame {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Racing racing = new Racing();

        Garage garage = racing.ready(InputView.inputCarName());

        racing.game(garage.getCars(), InputView.inputGameCount());
    }

}