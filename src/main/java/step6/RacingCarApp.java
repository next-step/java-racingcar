package step6;

import step6.domain.CarNames;
import step6.view.InputView;

public class RacingCarApp {
    public static void main(String[] args) {
        CarNames carNames = new CarNames(InputView.requireCarName());
        InputView.requireTryNumber();
    }
}
