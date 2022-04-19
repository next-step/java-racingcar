package racingcar.view;

import racingcar.Cars;

public class ResultView {

    private static final String MOVED_EXPRESSION = "-";

    private ResultView() {
        throw new IllegalStateException("Utility class.");
    }

    public static void printCarsPosition (Cars cars) {
        cars.getCars().forEach(car -> print(car.getDistance()));
        System.out.println();
    }

    private static void print(int distance) {
        StringBuilder builder = new StringBuilder();
        builder.append(MOVED_EXPRESSION.repeat(Math.max(0, distance)));
        System.out.println(builder.toString());
    }
}
