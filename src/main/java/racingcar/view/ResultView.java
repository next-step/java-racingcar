package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;

public enum ResultView {

    INSTANCE;

    private final String RESULT_STATEMENT = "실행 결과";

    public void printResultStatement() {
        System.out.println();
        System.out.println(RESULT_STATEMENT);
    }

    public void printEachRoundResult(List<Integer> movementRangeOfCars) {

        for (int movementRange : movementRangeOfCars) {
            IntStream.range(0, movementRange)
                    .mapToObj(i -> "-")
                    .forEach(System.out::print);
            System.out.println();
        }
        System.out.println();
    }
}
