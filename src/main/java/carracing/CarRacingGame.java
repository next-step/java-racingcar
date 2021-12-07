package carracing;

import carracing.console.InputConsole;
import carracing.console.OutputConsole;
import carracing.domain.*;
import carracing.util.RandomGenerator;

/**
 * 자동차 경주 게임을 구현한 클래스
 */
public class CarRacingGame {
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final MovementPolicy movementPolicy = new RandomIntMovementPolicy(randomGenerator);

    public void run() {
        String carNames = InputConsole.readCarNames();
        int numberOfTrials = InputConsole.readNumberOfTrials();

        OutputConsole.printResultMessage();
        Cars cars = new Cars(new CarNames(carNames));
        CarsGroup carsGroup = new CarsGroup(cars, numberOfTrials, movementPolicy);
        OutputConsole.printResultOfRacingGame(carsGroup);
    }
}
