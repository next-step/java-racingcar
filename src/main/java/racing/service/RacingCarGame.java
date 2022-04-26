package racing.service;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Position;
import racing.domain.RacingHistories;
import racing.domain.RoundHistory;
import racing.domain.strategies.CarMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final int MINIMUM_NUMBER_OF_MOVES = 1;
    private static final String EXCEPTION_MOVES_MESSAGE = "이동횟수는 %d 이상이어야 합니다";
    private static final String EXCEPTION_NAMES_MESSAGE = "자동차 이름은 필수값입니다";
    private static final String EXCEPTION_STRATEGY_MESSAGE = "이동 전략은 필수값입니다";

    private Cars makeCars(List<String> nameOfCars) {
        return new Cars(nameOfCars);
    }

    public RacingHistories run(int numMoves, List<String> nameOfCars, CarMoveStrategy moveStrategy) {
        if (numMoves < MINIMUM_NUMBER_OF_MOVES) {
            throw new IllegalArgumentException(String.format(EXCEPTION_MOVES_MESSAGE, MINIMUM_NUMBER_OF_MOVES));
        }

        if (nameOfCars == null || nameOfCars.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_NAMES_MESSAGE);
        }

        if (moveStrategy == null) {
            throw new IllegalArgumentException(EXCEPTION_STRATEGY_MESSAGE);
        }

        Cars cars = makeCars(nameOfCars);

        List<RoundHistory> roundHistories = play(numMoves, moveStrategy, cars);
        List<String> winners = getWinners(cars);
        return new RacingHistories(winners, roundHistories);
    }

    private List<RoundHistory> play(int numMoves, CarMoveStrategy moveStrategy, Cars cars) {
        List<RoundHistory> roundHistories = new ArrayList<>();
        for (int i = 0; i < numMoves; i++) {
            cars.run(moveStrategy);
            roundHistories.add(makeRoundHistory(cars));
        }
        return roundHistories;
    }

    private RoundHistory makeRoundHistory(Cars cars) {
        Map<String, Position> carPositions = cars.getCars().stream().collect(Collectors.toMap(Car::getName, Car::getPosition));
        return new RoundHistory(carPositions);
    }

    private List<String> getWinners(Cars cars) {
        Position maxPosition = cars.getMaxPosition();
        return cars.getCarsEqualsPosition(maxPosition);
    }
}
