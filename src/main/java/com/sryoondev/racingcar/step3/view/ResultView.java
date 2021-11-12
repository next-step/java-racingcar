package com.sryoondev.racingcar.step3.view;

import com.sryoondev.racingcar.step3.Circuit;
import com.sryoondev.racingcar.step3.MyCar;

public class ResultView {
    public static void initialize() {
        System.out.println("실행 결과");
    }
    public static void draw(Circuit circuit) {
        System.out.println();
    }

    public static void draw(MyCar car) {
        System.out.println(car.getMovement());
    }
}
