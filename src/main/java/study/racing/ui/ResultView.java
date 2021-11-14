package study.racing.ui;

import study.racing.model.Result;
import study.racing.model.car.Car;

public final class ResultView {

    private static final String DISTANCE_SYMBOL = "-";
    private static final StringBuilder builder = new StringBuilder();

    private ResultView() {
    }

    public static void printResult(Result result) {
        result.getResult().forEach(car -> doPrint(car));
        System.out.println();
    }

    private static void doPrint(Car car) {
        builder.setLength(0);
        for (int i = 0; i < car.getDistance(); i++) {
            builder.append(DISTANCE_SYMBOL);
        }
        System.out.println(builder);
    }
}
