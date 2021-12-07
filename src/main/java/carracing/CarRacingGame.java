package carracing;

import carracing.console.InputConsole;
import carracing.console.OutputConsole;
import carracing.domain.*;
import carracing.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

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
        CarsGroup carsGroup = new CarsGroup(carsGroup(cars, numberOfTrials, movementPolicy));
        OutputConsole.printResultOfRacingGame(carsGroup);
    }

    private List<Cars> carsGroup(Cars cars, int numberOfTrials, MovementPolicy movementPolicy) {
        List<Cars> carsGroup = new ArrayList<>(numberOfTrials);
        carsGroup.add(cars);
        for (int i = 0; i < numberOfTrials - 1; i++) {
            cars = cars.moveCars(movementPolicy);
            carsGroup.add(cars);
        }
        return carsGroup;
    }
}
