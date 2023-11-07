package step4.game;

import step4.input.InputView;
import step4.input.UserInput;
import step4.racingcar.RacingCar;
import step4.random.RandomValueGenerator;
import step4.result.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void start() {
        //inputView
        final UserInput userInput = InputView.input();

        List<RacingCar> cars = makeCars(userInput.getCarNames());

        //resultView
        ResultView.printResultText();

        for (int i = 0; i < userInput.getTryNumber(); i++) {
            tryMove(cars);
            ResultView.printTryResult(cars);
        }
    }

    private static List<RacingCar> makeCars(final String[] carNames) {
        List<RacingCar> cars = new ArrayList<>();

        for (final String carName : carNames) {
            cars.add(new RacingCar(carName));
        }

        return cars;
    }

    private static void tryMove(final List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.moveIfInRange(RandomValueGenerator.generateRandomValueFromZeroToNine());
        }
    }
}
