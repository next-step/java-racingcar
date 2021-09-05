package step6;

import step6.domain.Cars;
import step6.domain.RacingGame;
import step6.domain.TryNumber;
import step6.view.InputView;
import step6.view.ResultView;

public class RacingCarApp {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.requireCarName());
        TryNumber tryNumber = new TryNumber(InputView.requireTryNumber());

        ResultView.printResultGuideMessage();
        RacingGame racingGame = new RacingGame(cars, tryNumber);
        racingGame.run();
    }
}
