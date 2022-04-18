package racing.service;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Position;
import racing.domain.strategies.CarMoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final int MINIMUM_NUMBER_OF_MOVES = 1;

    private final CarMoveStrategy moveStrategy;
    private Cars cars;

    public RacingCarGame(List<String> nameOfCars, CarMoveStrategy moveStrategy) {
        if (nameOfCars == null || nameOfCars.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.moveStrategy = moveStrategy;
        makeCars(nameOfCars);
    }

    private void makeCars(List<String> nameOfCars) {
        cars = new Cars(nameOfCars);
    }

    public void run(int numMoves) {
        if (numMoves < MINIMUM_NUMBER_OF_MOVES) {
            throw new IllegalArgumentException();
        }
        cars.run(moveStrategy);
    }

    public List<String> getWinner() {
        Position maxPosition = cars.getMaxPosition();
        return cars.getCarsEqualsPosition(maxPosition)
                .stream().map(Car::getName)
                .collect(Collectors.toList());
    }

    public Cars getCars() {
        return cars;
    }
}
