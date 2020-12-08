package carracing;

import carracing.console.InputConsole;
import carracing.console.OutputConsole;
import carracing.domain.*;
import carracing.util.RandomGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 경주 게임을 구현한 클래스
 */
public class CarRacingGame {
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final MovementPolicy movementPolicy = new RandomIntMovementPolicy(randomGenerator);

    public void run() {
        CarNames carNames = new CarNames(convertCarNames(InputConsole.readCarNames()));
        int numberOfTrials = InputConsole.readNumberOfTrials();
        OutputConsole.printResultMessage();
        initiate(carNames, numberOfTrials);
    }

    private void initiate(CarNames carNames, int numberOfTrials) {
        Cars cars = new Cars(carNames);
        for (int i = 0; i < numberOfTrials; i++) {
            cars.moveCars(movementPolicy);
            OutputConsole.printStatusOfRacing(cars);
        }
        OutputConsole.printWinningCarsOfRacing(cars);
    }

    private List<CarName> convertCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(CarName::new)
                .collect(Collectors.toList());
    }
}
