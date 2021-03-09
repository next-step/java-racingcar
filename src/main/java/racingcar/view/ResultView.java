package racingcar.view;

import java.util.List;

public enum ResultView {

    INSTANCE;

    private final String RESULT_STATEMENT = "실행 결과";

    public void printResultStatement() {
        System.out.println();
        System.out.println(RESULT_STATEMENT);
    }

    public void printEachRoundResult(List<Integer> movementRangeOfCars) {

        for (int movementRange : movementRangeOfCars) {
            for (int i = 0; i < movementRange; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
