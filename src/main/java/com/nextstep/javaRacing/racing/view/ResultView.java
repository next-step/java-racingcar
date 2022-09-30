package com.nextstep.javaRacing.racing.view;

import com.nextstep.javaRacing.racing.car.Car;

import java.util.List;

public class ResultView {

    public static void draw(int turn, List<Car> cars) {
        System.out.println();
        System.out.println("turn : "+turn);
        cars.forEach(ResultView::drawCar);
    }

    private static void drawCar(Car car) {
        System.out.println("-".repeat(car.getPosition()) + "|" + car.getName());
    }
}
