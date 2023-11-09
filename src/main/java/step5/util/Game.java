package step5.util;

import step5.domain.RacingCar;
import step5.domain.UserInput;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.List;

public class Game {
    public static void start() {
        //inputView
        final UserInput userInput = InputView.input();

        List<RacingCar> cars = GameManager.makeCars(userInput.getCarNames());

        //resultView
        ResultView.printResultText();

        for (int i = 0; i < userInput.getTryNumber(); i++) {
            tryMove(cars);
            ResultView.printTryResult(cars);
        }

        ResultView.printWinners(GameManager.toNames(GameManager.extractWinners(cars)));
    }

    private static void tryMove(final List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.moveIfInRange(RandomValueGenerator.generateRandomValueFromZeroToNine());
        }
    }
}
