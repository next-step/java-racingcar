package com.nextstep.javaRacing.racing.view;

import com.nextstep.javaRacing.racing.car.Car;

import java.util.List;

public class ResultView {

    public static void drawCircuit(int turn, List<Car> cars) {
        System.out.println();
        System.out.println("turn : "+ (turn+1));
        cars.forEach(ResultView::drawCar);
    }

    private static void drawCar(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }
}
