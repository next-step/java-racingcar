package racing;

import racing.GameResult.GameRoundResult;
import racing.model.Car;
import racing.model.CarMoveStrategyImpl;
import racing.model.CustomRandomImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame {
    List<Car> cars = new ArrayList<>();

    public RacingCarGame(int numCars) {
        if (numCars < 1) {
            throw new IllegalArgumentException();
        }
        makeCars(numCars);
    }

    private void makeCars(int numCars) {
        IntStream.range(0, numCars)
                .mapToObj(i -> new CustomRandomImpl())
                .map(CarMoveStrategyImpl::new)
                .forEach(carMoveStrategy -> cars.add(new Car(carMoveStrategy)));
    }

    public GameResult run(int numMoves) {
        if (numMoves < 1) {
            throw new IllegalArgumentException();
        }

        GameResult gameResult = new GameResult();
        for (int i = 0; i < numMoves; i++) {
            GameRoundResult round = new GameRoundResult();
            gameResult.addRoundResult(round);
            cars.stream()
                    .mapToInt(Car::run)
                    .forEach(round::addResult);
        }
        return gameResult;
    }
}
