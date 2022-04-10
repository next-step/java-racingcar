package racing;

import racing.GameResult.GameRoundResult;
import racing.model.Car;
import racing.model.CarMoveStrategy;
import racing.model.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {
    private static final int MINIMUM_NUMBER_OF_CARS = 1;
    private static final int MINIMUM_NUMBER_OF_MOVES = 1;

    private final CarMoveStrategy moveStrategy;
    private Cars cars;

    public RacingCarGame(int numCars, CarMoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        if (numCars < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException();
        }
        makeCars(numCars);
    }

    private void makeCars(int numCars) {
        List<Car> carList = IntStream.range(0, numCars).mapToObj(i -> new Car()).collect(Collectors.toList());
        cars = new Cars(carList);
    }

    public GameResult run(int numMoves) {
        if (numMoves < MINIMUM_NUMBER_OF_MOVES) {
            throw new IllegalArgumentException();
        }

        GameResult gameResult = new GameResult();
        for (int i = 0; i < numMoves; i++) {
            GameRoundResult result = cars.run(moveStrategy);
            gameResult.addRoundResult(result);
        }
        return gameResult;
    }
}
