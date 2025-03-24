package racing.domain.model;

import racing.domain.strategy.MoveStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Round {

    private final int roundNumber;
    private final MoveStrategy moveStrategy;
    private Map<Car, Integer> carPositions;

    public Round(final int roundNumber, final MoveStrategy moveStrategy) {
        this.roundNumber = roundNumber;
        this.moveStrategy = moveStrategy;
        this.carPositions = new HashMap<>();
    }

    public void execute(final Cars cars) {
        carPositions = cars.getAll().stream().collect(Collectors.toMap(Function.identity(), this::determineCarPosition));
    }

    private int determineCarPosition(final Car car) {
        if (moveStrategy.shouldMove()) {
            return car.moveForward();
        }
        return car.getPosition();
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public Map<Car, Integer> getCarPositions() {
        return Collections.unmodifiableMap(carPositions);
    }
}
