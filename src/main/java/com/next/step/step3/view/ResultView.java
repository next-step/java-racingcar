package com.next.step.step3.view;

import com.next.step.step3.domain.Car;
import com.next.step.step3.domain.Cars;

import java.util.List;

public class ResultView {

    private static final String RESULT_TITLE = "실행 결과";

    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";

    private static final String RESULT_DELIMITER = "";

    private static final String MOVE_MARK = "-";

    private static final String NAME_RESULT_DELIMITER = " : ";

    private static final String NAME_DELIMITER = ", ";

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
        System.out.print(NAME_RESULT_DELIMITER);
        for (int moveCount = 0; moveCount < car.position(); moveCount++) {
            System.out.print(MOVE_MARK);
        }
        System.out.println(RESULT_DELIMITER);
    }

    public void showWinnerNames(List<String> winnerNames) {
        String joinNameByDelimiter = String.join(NAME_DELIMITER, winnerNames);
        System.out.print(joinNameByDelimiter);
        System.out.println(WINNER_SUFFIX);
    }
}
