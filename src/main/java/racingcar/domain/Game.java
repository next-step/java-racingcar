package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int carCount;
    private final int roundCount;

    public Game(final InputData inputData) {
        carCount = inputData.getCarCount();
        roundCount = inputData.getRoundCount();
    }

    public List<Records> playGame(final MoveStrategy randomMoveStrategy) {
        CarFactory carFactory = new CarFactory(carCount);
        return simulateRounds(carFactory, randomMoveStrategy);
    }

    private List<Records> simulateRounds(final CarFactory carFactory, final MoveStrategy randomMoveStrategy) {
        List<Records> allRecords = new ArrayList<>();

        for (int i = 0; i < roundCount; i++) {
            Records roundRecords = race(carFactory, randomMoveStrategy);
            allRecords.add(roundRecords);
        }

        return allRecords;
    }

    private Records race(final CarFactory carFactory, final MoveStrategy randomMoveStrategy) {
        Records roundRecords = new Records();

        for (Car car : carFactory.getCars()) {
            car.move(randomMoveStrategy);
            roundRecords.addRecord(new Record(car.getPosition()));
        }
        return roundRecords;
    }
}
