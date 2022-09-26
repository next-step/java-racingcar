package com.nextstep.javaRacing.racing.view;

import com.nextstep.javaRacing.racing.car.Car;

import java.util.List;

public class ResultView {

    public static void draw(int turn, List<Car> cars) {
        System.out.println("\nturn : "+turn);
        cars.forEach(System.out::println);
    }
}
