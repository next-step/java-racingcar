package com.nextstep.javaRacing.racing.race;

import com.nextstep.javaRacing.racing.car.Car;
import com.nextstep.javaRacing.racing.view.ResultView;

import java.util.List;

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

    public static void start() {
        Race race = RaceFactory.prepareRace();
        race.race();
    }

    public void race() {
        for (int turn = 0; turn < turns; turn++) {
            move();
            draw(turn);
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    private void draw(int turn) {
        ResultView.draw(turn, cars);
    }
}
