package edu.nextstep.camp.racinggame.domain.race;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import edu.nextstep.camp.racinggame.domain.car.Car;
import edu.nextstep.camp.racinggame.domain.car.Cars;
import edu.nextstep.camp.racinggame.domain.car.Position;

public class Race {
    private final Turns turns;
    private final Cars cars;

    private Race(Cars cars, Turns turns) {
        this.cars = cars;
        this.turns = turns;
    }

    public static Race of(Cars cars, Turns turns) {
        if (cars == null) {
            throw new IllegalArgumentException("cars cannot be null.");
        }

        if (turns == null) {
            throw new IllegalArgumentException("turns cannot be null.");
        }

        return new Race(cars, turns);
    }

    public Turn totalTurns() {
        return turns.total();
    }

    public int numberOfCars() {
        return cars.size();
    }

    public Collection<Position> gameResult() {
        return cars.stream()
                .map(Car::position)
                .collect(Collectors.toList());
    }

    public void process() {
        if (turns.hasNext()) {
            cars.forEach(Car::attemptToMove);
            turns.next();
        }
    }

    public boolean isEnded() {
        return !turns.hasNext();
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
