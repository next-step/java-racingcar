package step5.util;

import step5.domain.RacingCar;
import step5.domain.UserInput;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.List;

public class Game {
    public static void start(final MoveStrategy moveStrategy) {
        final UserInput userInput = InputView.input();

        List<RacingCar> cars = GameManager.makeCars(userInput.getCarNames());

        ResultView.printResultText();

        for (int i = 0; i < userInput.getTryNumber(); i++) {
            tryMove(cars, moveStrategy);
            ResultView.printTryResult(cars);
        }

        ResultView.printWinners(GameManager.toNames(GameManager.extractWinners(cars)));
    }

    private static void tryMove(final List<RacingCar> cars, final MoveStrategy moveStrategy) {
        for (RacingCar car : cars) {
            car.moveIfInRange(moveStrategy.getMoveValue());
        }
    }
}
