package carracing;

import carracing.view.InputView;
import carracing.view.OutputView;
import carracing.domain.CarNames;
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
        CarNames carNames = new CarNames(InputView.readCarNames());
        int numberOfTrials = InputView.readNumberOfTrials();
        OutputView.printResultMessage();
        initiate(carNames, numberOfTrials);
    }

    private void initiate(CarNames carNames, int numberOfTrials) {
        Cars cars = new Cars(carNames);
        for (int i = 0; i < numberOfTrials; i++) {
            cars.moveCars(movementPolicy);
            OutputView.printStatusOfRacing(cars);
        }
        OutputView.printWinningCarsOfRacing(cars);
    }
}
