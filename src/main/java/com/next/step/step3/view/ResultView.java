package com.next.step.step3.view;

import com.next.step.step3.domain.Car;
import com.next.step.step3.domain.MoveResult;
import com.next.step.step3.domain.MoveResults;

import java.util.List;

public class ResultView {

    private static final String RESULT_TITLE = "실행 결과";

    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";

    private static final String RESULT_DELIMITER = "";

    private static final String MOVE_MARK = "-";

    private static final String NAME_RESULT_DELIMITER = " : ";

    private static final String NAME_DELIMITER = ", ";

    private final MoveResults moveResults;

    public ResultView(MoveResults moveResults) {
        this.moveResults = moveResults;
    }

    public void showResult() {
        System.out.println(RESULT_TITLE);

        moveResults.getMoveResults()
                .forEach(this::showCarContents);

        showWinnerNames(moveResults.getWinnerNames());
    }

    private void showCarContents(MoveResult moveResult) {
        for (Car car : moveResult.getCarElement()) {
            System.out.print(car.name());
            System.out.print(NAME_RESULT_DELIMITER);
            showMarkTrace(car);
            System.out.println(RESULT_DELIMITER);
        }
        System.out.println(RESULT_DELIMITER);
    }

    private void showMarkTrace(Car car) {
        for (int trace = 0; trace < car.position(); trace++) {
            System.out.print(MOVE_MARK);
        }
    }

    private void showWinnerNames(List<String> winnerNames) {
        String joinNameByDelimiter = String.join(NAME_DELIMITER, winnerNames);
        System.out.print(joinNameByDelimiter);
        System.out.println(WINNER_SUFFIX);
    }
}
