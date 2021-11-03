package carracing;

import carracing.console.InputConsole;
import carracing.console.OutputConsole;
import carracing.domain.Cars;
import carracing.domain.MovementPolicy;
import carracing.domain.RandomIntMovementPolicy;
import carracing.util.RandomGenerator;

/**
 * 자동차 경주 게임을 구현한 클래스
 */
public class CarRacingGame {
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final MovementPolicy movementPolicy = new RandomIntMovementPolicy(randomGenerator);

    public void run() {
        int numberOfCars = InputConsole.readNumberOfCars();
        int numberOfTrials = InputConsole.readNumberOfTrials();

        OutputConsole.printResultMessage();
        Cars cars = new Cars(numberOfCars);
        for (int i = 0; i < numberOfTrials; i++) {
            cars.moveCars(movementPolicy);
            OutputConsole.printStatusOfRacing(cars);
        }
    }
}
