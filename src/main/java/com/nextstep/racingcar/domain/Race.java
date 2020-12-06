package com.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Race {
    private static final String DELIMITER = ",";
    private static final String SEPARATOR = System.lineSeparator();
    private static final String EMPTY = "";

    private int moveCount;
    private List<Car> cars = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public Race(List<CarName> carNames, int moveCount, Supplier<Integer> numberGenerator) {
        this.moveCount = moveCount;
        for (CarName carName : carNames) {
            cars.add(new Car(carName, numberGenerator));
        }
    }

    public void run() {
        for (int ix = 0 ; ix < moveCount ; ix ++) {
            move();
        }
    }

    private void move() {
        for (Car car : cars) {
            car.tryMove();
            addLog(car.toDetailString());
        }
        addLog();
    }

    private void addLog() {
        addLog(EMPTY);
    }

    private void addLog(String message) {
        stringBuilder.append(message)
                .append(SEPARATOR);
    }

    public String getPositionLog() {
        return stringBuilder.toString();
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
