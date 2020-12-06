package com.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Race {
    private static final String DELIMITER = ",";

    private int moveCount;
    private List<Car> cars = new ArrayList<>();
    private Consumer<List<Car>> movePrinter = null;

    public Race(List<CarName> carNames, int moveCount, Supplier<Integer> numberGenerator) {
        this.moveCount = moveCount;
        for (CarName carName : carNames) {
            cars.add(new Car(carName, numberGenerator));
        }
    }

    public void setMovePrinter(Consumer<List<Car>> movePrinter) {
        this.movePrinter = movePrinter;
    }

    public void run() {
        for (int ix = 0 ; ix < moveCount ; ix ++) {
            move();
        }
    }

    private void move() {
        for (Car car : cars) {
            car.tryMove();
        }
        movePrint();
    }

    private void movePrint() {
        if (movePrinter != null) {
            movePrinter.accept(cars);
        }
    }

    public String getWinnerNames() {
        Car winner = getWinner();
        return cars.stream()
                .filter(car -> car.equalsPosition(winner))
                .map(Car::toString)
                .collect(Collectors.joining(DELIMITER));
    }

    private Car getWinner() {
        Car winner = cars.get(0);
        for (Car car : cars) {
            winner = winner.compareAndGet(car);
        }
        return winner;
    }
}
