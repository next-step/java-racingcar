package carracing.controller;

import carracing.view.InputView;
import carracing.view.OutputView;
import carracing.domain.CarNameGroup;
import carracing.domain.Cars;
import carracing.domain.MovementPolicy;
import carracing.domain.RandomIntMovementPolicy;
import carracing.util.RandomGenerator;

/**
 * 자동차 경주 게임을 구현한 클래스
 */
public class CarRacingGameController {
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final MovementPolicy movementPolicy = new RandomIntMovementPolicy(randomGenerator);

    public void run() {
        CarNameGroup carNameGroup = new CarNameGroup(InputView.readCarNames());
        int numberOfTrials = InputView.readNumberOfTrials();
        OutputView.printResultMessage();
        initiate(carNameGroup, numberOfTrials);
    }

    private void initiate(CarNameGroup carNameGroup, int numberOfTrials) {
        Cars cars = new Cars(carNameGroup);
        for (int i = 0; i < numberOfTrials; i++) {
            cars.moveCars(movementPolicy);
            OutputView.printStatusOfRacing(cars);
        }
        OutputView.printWinningCarsOfRacing(cars);
    }
}
