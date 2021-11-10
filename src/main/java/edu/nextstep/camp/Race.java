package edu.nextstep.camp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private static final int MINIMUM_TOTAL_TURN = 1;
    private static final int INITIAL_TURN = 0;

    private final int totalTurns;
    private final Cars cars;
    private int currentTurn;

    private Race(Cars cars, int totalTurns) {
        this.cars = cars;
        this.currentTurn = INITIAL_TURN;
        this.totalTurns = totalTurns;
    }

    public static Race of(Cars cars, int turn) {
        if (cars == null) {
            throw new IllegalArgumentException("cars must not be null: " + cars);
        }

        if (turn < MINIMUM_TOTAL_TURN) {
            throw new IllegalArgumentException("invalid number of turns: " + turn);
        }

        return new Race(cars, turn);
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

    public List<String> winners() {
        if (!isEnded()) {
            throw new IllegalStateException("the race is not over.");
        }

        final Position maxPosition = cars.stream()
                .map(Car::position)
                .max(Comparator.naturalOrder())
                .orElseGet(Position::ofZero);

        return cars.stream()
                .filter(car -> car.position().equals(maxPosition))
                .map(Car::name)
                .collect(Collectors.toList());
    }
}
