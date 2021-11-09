package edu.nextstep.camp;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private static final int MINIMUM_TOTAL_TURN = 1;
    private static final int INITIAL_TURN = 0;

    private int currentTurn;
    private final int totalTurns;
    private final List<Car> cars;

    public static Race of(List<Car> cars, int turn) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("cars must not be empty: " + cars);
        }

        if (turn < MINIMUM_TOTAL_TURN) {
            throw new IllegalArgumentException("invalid number of turns: " + turn);
        }

        return new Race(cars, turn);
    }

    private Race(List<Car> cars, int totalTurns) {
        this.cars = Collections.unmodifiableList(cars);
        this.currentTurn = INITIAL_TURN;
        this.totalTurns = totalTurns;
    }

    public int totalTurns() {
        return totalTurns;
    }

    public int numberOfCars() {
        return cars.size();
    }

    public List<Integer> gameResult() {
        return cars.stream()
                .map(Car::position)
                .map(Position::toInt)
                .collect(Collectors.toList());
    }

    public void process() {
        if (currentTurn < totalTurns) {
            cars.forEach(Car::attemptToMove);
            currentTurn++;
        }
    }

    public boolean isEnded() {
        return currentTurn >= totalTurns;
    }
}
