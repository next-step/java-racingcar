package study.racing.ui;

import java.util.List;

import study.racing.model.Result;
import study.racing.model.car.Car;

public final class ResultView {

    private static final String DISTANCE_SYMBOL = "-";
    private static final StringBuilder builder = new StringBuilder();

    private ResultView() {
    }

    public static void printResult(List<Result> results) {
        results.forEach(ResultView::doPrint);
    }

    private static void doPrint(Result result) {
        result.getResult().forEach(ResultView::doPrint);
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
