package racingcar.view;

import java.util.stream.IntStream;

import racingcar.domain.Cars;

public class ResultView {

    private static final String RESULT = "실행 결과";
    private static final String HYPHEN = "-";

    public static void print(Cars cars, int tryCount) {
        System.out.println(RESULT);
        printPositions(cars);

        move(cars, tryCount);
    }

    private static void printPositions(Cars cars) {
        cars.getPositions()
            .forEach(ResultView::printHyphens);
        System.out.println();
    }

    private static void printHyphens(int value) {
        System.out.println(HYPHEN.repeat(value));
    }

    private static void move(Cars cars, int tryCount) {
        IntStream.range(0, tryCount)
            .forEach(count -> move(cars));
    }

    private static void move(Cars cars) {
        cars.move();
        printPositions(cars);
    }
}
