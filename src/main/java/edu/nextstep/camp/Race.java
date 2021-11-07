package edu.nextstep.camp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private int currentTurn;
    private final int totalTurns;
    private final List<Car> cars;

    public static Race of(int numberOfCars, int turn) {
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException("invalid number of cars: " + numberOfCars);
        }

        List<Car> cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        return of(cars, turn);
    }

    public static Race of(List<Car> cars, int turn) {
        if (cars == null || cars.isEmpty()){
            throw new IllegalArgumentException("cars must not be empty: " + cars);
        }

        if (turn <= 0) {
            throw new IllegalArgumentException("invalid number of turns: " + turn);
        }

        return new Race(cars, turn);
    }

    private Race(List<Car> cars, int totalTurns) {
        this.cars = Collections.unmodifiableList(cars);
        this.currentTurn = 0;
        this.totalTurns = totalTurns;
    }

    public int totalTurns() {
        return totalTurns;
    }

    public int numberOfCars() {
        return cars.size();
    }

    public List<Integer> gameResult() {
        return cars.stream().map(Car::position).map(Position::toInt).collect(Collectors.toList());
    }

    public void process() {
        if (currentTurn < totalTurns) {
            cars.forEach(Car::attempToMove);
            currentTurn++;
        }
    }

    public void processAll() {
        for (; currentTurn < totalTurns; currentTurn++) {
            cars.forEach(Car::attempToMove);
        }
    }
}
