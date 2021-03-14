package racingcar.view;

import java.util.Queue;
import java.util.stream.IntStream;

public enum ResultView {

    INSTANCE;

    private final String RESULT_STATEMENT = "실행 결과";
    private final String DELEMETER = " : ";

    public void printResultStatement() {
        System.out.println();
        System.out.println(RESULT_STATEMENT);
    }

    public void printEachRoundResult(Queue<String> nameOfCars, Queue<Integer> movementRangeOfCars) {
        int numberOfCars = nameOfCars.size();

        for (int i = 0; i < numberOfCars; i++) {
            String name = nameOfCars.poll();
            System.out.print(name + DELEMETER);
            Integer movementRange = movementRangeOfCars.poll();
            IntStream.range(0, movementRange)
                    .mapToObj(j -> "-")
                    .forEach(System.out::print);
            System.out.println();
        }
        System.out.println();
    }
}
