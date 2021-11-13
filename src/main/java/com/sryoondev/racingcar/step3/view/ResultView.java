package com.sryoondev.racingcar.step3.view;

import com.sryoondev.racingcar.step3.Car;
import com.sryoondev.racingcar.step3.Circuit;

public class ResultView {
    private final StringBuilder resultBuilder;

    public ResultView() {
        this.resultBuilder = new StringBuilder();
    }

    public void capture(Circuit circuit) {
        resultBuilder.append("\n");
    }

    public void capture(Car car) {
        for (int i = 0; i < car.getMoveDistance(); i++) {
            resultBuilder.append("-");
        }
        resultBuilder.append("\n");
    }

    public void draw() {
        System.out.println("실행 결과");
        System.out.print(resultBuilder);
    }
}
