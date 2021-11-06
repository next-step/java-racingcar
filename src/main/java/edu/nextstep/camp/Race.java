package edu.nextstep.camp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final int totalTurns;
    private final List<Car> cars;

    public static Race of(int numberOfCars, int turn) {
        if (numberOfCars <= 0)
            throw new IllegalArgumentException("invalid number of cars: " + numberOfCars);

        if (turn <= 0)
            throw new IllegalArgumentException("invalid number of turns: " + turn);

        return new Race(numberOfCars, turn);
    }

    private Race(int numberOfCars, int totalTurns) {
        this.cars = new ArrayList<>(numberOfCars);
        for(int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }

        this.totalTurns = totalTurns;
    }

    public int totalTurns() {
        return totalTurns;
    }

    public int numberOfCars() {
        return cars.size();
    }

    public List<Integer> gameResult() {
        return cars.stream().map(Car::position).collect(Collectors.toList());
    }
}
