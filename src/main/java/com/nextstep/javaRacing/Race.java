package com.nextstep.javaRacing;

import com.nextstep.javaRacing.view.InputView;

import java.util.List;

public class Race {

    protected List<Car> cars;
    protected int turns;

    protected Race(List<Car> cars, int turns){
        this.cars = cars;
        this.turns = turns;
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
    }
}
