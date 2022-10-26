package racing;

import racing.domain.Cars;
import racing.view.RacingInputView;

public class RacingMain {
    public static void main(String[] args) {
        int carCount = RacingInputView.inputCarCount();
        int gameCount = RacingInputView.inputGameCount();

        RacingGame.race(gameCount, Cars.makeCars(carCount));
    }
}
