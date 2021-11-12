package com.sryoondev.racingcar.step3.view;

import com.sryoondev.racingcar.step3.MyCar;
import com.sryoondev.racingcar.step3.MyRacing;

public class ResultView {
    public static void initialize() {
        System.out.println("실행 결과");
    }
    public static void draw(MyRacing myRacing) {
        System.out.println();
    }

    public static void draw(MyCar car) {
        System.out.println(car.getMovement());
    }
}
