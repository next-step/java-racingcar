package edu.nextstep.camp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final Turn turn;
    private final Cars cars;

    private Race(Cars cars, Turn turns) {
        this.cars = cars;
        this.turn = turns;
    }

    public static Race of(Cars cars, Turn turn) {
        if (cars == null) {
            throw new IllegalArgumentException("cars cannot be null.");
        }

        if (turn == null) {
            throw new IllegalArgumentException("turns cannot be null.");
        }

        return new Race(cars, turn);
    }

    public int totalTurns() {
        return turn.total();
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
        if (turn.hasNext()) {
            cars.forEach(Car::attemptToMove);
            turn.next();
        }
    }

    public boolean isEnded() {
        return !turn.hasNext();
    }

    public Position maxPosition() {
        return cars.stream()
                .map(Car::position)
                .max(Comparator.naturalOrder())
                .orElseGet(Position::ofZero);
    }

    public Winners winners() {
        if (!isEnded()) {
            throw new IllegalStateException("the race is not over.");
        }

        final Position maxPosition = maxPosition();
        return Winners.of(cars.stream()
                .filter(car -> car.isPositionOf(maxPosition))
                .map(Car::name));
    }
}
