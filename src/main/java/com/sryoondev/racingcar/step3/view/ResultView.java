package com.sryoondev.racingcar.step3.view;

import com.sryoondev.racingcar.step3.Car;
import com.sryoondev.racingcar.step3.Circuit;

public class ResultView {
    public static void drawTitle() {
        System.out.println("실행 결과");
    }
    public static void draw(Circuit circuit) {
        System.out.println();
    }

    public static void draw(Car car) {
        for (int i = 0; i < car.getMoveDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
