package com.nextstep.javaRacing.race;

import com.nextstep.javaRacing.car.Car;
import com.nextstep.javaRacing.view.InputView;
import com.nextstep.javaRacing.view.ResultView;

import java.util.List;

public class Race {

    protected final List<Car> cars;
    protected final int turns;

    protected Race(List<Car> cars, int turns) {
        this.cars = cars;
        this.turns = turns;
    }

    public static void start() {
        InputView inputView = new InputView();
        Race race = RaceFactory.prepareRace(inputView);
        race.race();
    }

    public static void main(String[] args) {
        Race.start();
    }

    public void race() {
        for (int turn = 0; turn < turns; turn++) {
            move();
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
        draw();
    }

    private void draw() {
        ResultView view = new ResultView(cars);
        view.draw();
    }
}
