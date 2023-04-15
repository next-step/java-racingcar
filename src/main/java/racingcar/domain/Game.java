package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String names;
    private final int roundCount;

    public Game(final InputData inputData) {
        names = inputData.getRawString();
        roundCount = inputData.getRoundCount();
    }

    /**
     * 게임을 진행하고, 총 라운드의 결과를 반환한다.
     * @param randomMoveStrategy
     * @return 총 라운드의 결과
     */
    public List<Records> playGame(final MoveStrategy randomMoveStrategy) {
        CarFactory carFactory = new CarFactory(names);
        return simulateRounds(carFactory, randomMoveStrategy);
    }

    /**
     * 라운드를 진행하고, 총 라운드의 결과를 반환한다.
     * @param carFactory
     * @param randomMoveStrategy
     * @return 총 라운드의 결과
     */
    private List<Records> simulateRounds(final CarFactory carFactory, final MoveStrategy randomMoveStrategy) {
        List<Records> allRecords = new ArrayList<>();

        for (int i = 0; i < roundCount; i++) {
            Records roundRecords = race(carFactory, randomMoveStrategy);
            allRecords.add(roundRecords);
        }

        return allRecords;
    }

    /**
     * 각 라운드를 진행하고, 각 라운드의 결과를 반환한다.
     * @param carFactory
     * @param randomMoveStrategy
     * @return 각 라운드의 결과
     */
    private Records race(final CarFactory carFactory, final MoveStrategy randomMoveStrategy) {
        Records roundRecords = new Records();

        for (Car car : carFactory.getCars()) {
            car.move(randomMoveStrategy);
            roundRecords.addRecord(new Record(car.getPosition(), car.getName()));
        }
        return roundRecords;
    }
}
