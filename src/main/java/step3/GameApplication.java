package step3;

import step3.view.InputView;
import step3.view.ResultView;

public class GameApplication {
    public static void main(String[] args) {

        RacingCar racingCar = new RacingCar(new InputView(), new ResultView());
        racingCar.run();
    }
}
