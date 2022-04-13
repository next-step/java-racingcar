package racing.service;

import racing.domain.Cars;
import racing.domain.strategies.CarMoveStrategy;
import racing.dto.GameResult;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame {
    private static final int MINIMUM_NUMBER_OF_CARS = 1;
    private static final int MINIMUM_NUMBER_OF_MOVES = 1;

    private final CarMoveStrategy moveStrategy;
    private Cars cars;

    public RacingCarGame(List<String> nameOfCars, CarMoveStrategy moveStrategy) {
        if (nameOfCars == null || nameOfCars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException();
        }

        this.moveStrategy = moveStrategy;
        makeCars(nameOfCars);
    }

    private void makeCars(List<String> nameOfCars) {
        cars = new Cars(nameOfCars);
    }

    public GameResult run(int numMoves) {
        if (numMoves < MINIMUM_NUMBER_OF_MOVES) {
            throw new IllegalArgumentException();
        }

        GameResult gameResult = new GameResult();
        IntStream.range(0, numMoves)
                .mapToObj(i -> cars.run(moveStrategy))
                .forEach(gameResult::addRoundResult);
        return gameResult;
    }
}
