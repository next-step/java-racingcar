package com.next.step.step3.view;

import com.next.step.step3.domain.Car;
import com.next.step.step3.domain.Cars;

public class ResultView {

    private static final String RESULT_TITLE = "실행 결과";

    private static final String RESULT_DELIMITER = "";

    private static final String MOVE_MARK = "-";

    private static final String NAME_RESULT_DELIMITER = " : ";

    public void showResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void showResultContents(Cars cars) {
        for (Car car : cars.carElements()) {
            markMoveTrace(car);
        }
        System.out.println(RESULT_DELIMITER);
    }

    private void markMoveTrace(Car car) {
        System.out.print(car.name());
        System.out.println(NAME_RESULT_DELIMITER);
        for (int moveCount = 0; moveCount < car.position(); moveCount++) {
            System.out.print(MOVE_MARK);
        }
        System.out.println(RESULT_DELIMITER);
    }
}
