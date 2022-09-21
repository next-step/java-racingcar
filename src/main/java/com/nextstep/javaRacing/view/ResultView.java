package com.nextstep.javaRacing.view;

import com.nextstep.javaRacing.car.Car;

import java.util.List;

public class ResultView {
    private final List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    public void draw() {
        System.out.println();
        for (Car car : cars) {
            drawCar(car);
        }
    }

    public void drawCar(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.position(); i++) {
            sb.append("-");
        }
        sb.append("|");
        sb.append(car.name());
        System.out.println(sb);
    }
}
