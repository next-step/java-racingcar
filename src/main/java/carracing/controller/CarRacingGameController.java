package carracing.controller;

import carracing.domain.*;
import carracing.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 경주 게임을 구현한 클래스
 */
public class CarRacingGameController {
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final MovementPolicy movementPolicy = new RandomIntMovementPolicy(randomGenerator);

    public CarsGroup run(String carNames, int numberOfTrials) {
        validate(carNames, numberOfTrials);
        return new CarsGroup(carsGroup(new Cars(new CarNames(carNames)), numberOfTrials, movementPolicy));
    }

    private void validate(String carNames, int numberOfTrials) {
        if (carNames == null || "".equals(carNames)) {
            throw new IllegalArgumentException(String.format("carNames(%s)는 문자열이 전달되어야합니다.", carNames));
        }
        if (numberOfTrials <= 0) {
            throw new IllegalArgumentException(String.format("numberOfTrials(%d)는 0보다 큰 값이 전달되어야합니다.", numberOfTrials));
        }
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
