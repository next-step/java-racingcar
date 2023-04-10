package com.next.step.step3.view;

import com.next.step.step3.domain.Car;
import com.next.step.step3.domain.Cars;

public class ResultView {

    private static final String RESULT_TITLE = "실행 결과";

    private static final String RESULT_DELIMITER = "";

    public void showResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void showResultContents(Cars cars) {
        for (Car car : cars.carElements()) {
            System.out.println(car.position());
        }
        System.out.println(RESULT_DELIMITER);
    }
}
