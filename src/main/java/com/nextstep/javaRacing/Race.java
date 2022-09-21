package com.nextstep.javaRacing;

import com.nextstep.javaRacing.view.InputView;
import com.nextstep.javaRacing.view.ResultView;

import java.util.List;

public class Race {

    protected List<Car> cars;
    protected int turns;

    protected Race(List<Car> cars, int turns) {
        this.cars = cars;
        this.turns = turns;
    }

    public static void start() {
        InputView inputView = new InputView();
        Race race = RaceFactory.prepareRace(inputView);
        race.race();
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

    public static void main(String[] args) {
        Race.start();
    }
}
