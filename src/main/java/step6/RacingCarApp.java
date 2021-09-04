package step6;

import step6.domain.Cars;
import step6.domain.TryNumber;
import step6.view.InputView;
import test.RacingGame;

public class RacingCarApp {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.requireCarName());
        TryNumber tryNumber = new TryNumber(InputView.requireTryNumber());
    }
}
