package com.nextstep.javaRacing.racing.race;

import com.nextstep.javaRacing.racing.car.Car;
import com.nextstep.javaRacing.racing.view.InputView;
import com.nextstep.javaRacing.racing.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    protected final List<Car> cars;
    protected final int turns;

    protected Race(List<Car> cars, int turns) {
        this.cars = cars;
        this.turns = turns;
    }

    public static void main(String[] args) {
        Race.start();
    }

    private static void start() {
        Race race = RaceFactory.prepareRace(InputView.scanCarNames(), InputView.scanTurns());
        race.race();
    }

    public void race() {
        for (int turn = 0; turn < turns; turn++) {
            move();
            drawCircuit(turn);
        }
        drawWinners(getWinners());
    }

    private void move() {
        cars.forEach(Car::move);
    }

    private void drawCircuit(int turn) {
        ResultView.drawCircuit(turn, cars);
    }

    private List<Car> getWinners() {
        int bestRecord = Collections.max(cars).getPosition();
        return cars.stream()
                .filter(car->car.getPosition()==bestRecord)
                .collect(Collectors.toList());
    }

    private void drawWinners(List<Car> winners) {
        ResultView.drawWinners(winners);
    }
}
