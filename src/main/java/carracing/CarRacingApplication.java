package carracing;

import carracing.controller.CarRacingGame;
import carracing.view.InputView;
import carracing.view.OutputView;

public class CarRacingApplication {
    public static void main(String[] args) {
        new CarRacingGame(new InputView(), new OutputView()).start();
    }
}
