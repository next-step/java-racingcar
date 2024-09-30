package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameApplication {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar(new InputView(), new ResultView());
        racingCar.run();
    }
}
