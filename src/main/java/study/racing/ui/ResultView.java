package study.racing.ui;

import java.util.List;

import study.racing.model.car.Car;

public final class ResultView {

    private static final String DISTANCE_SYMBOL = "-";
    private static final StringBuilder builder = new StringBuilder();

    private ResultView() {
    }

    public static void printResult(List<Car> result) {
        result.forEach(car -> doPrint(car));
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
