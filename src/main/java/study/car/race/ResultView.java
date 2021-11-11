package study.car.race;

import java.util.List;

public class ResultView {

    private static final String DISTANCE_SYMBOL = "-";

    private ResultView() {
    }

    public static void printResult(List<Car> result) {
        result.stream()
              .forEach(car -> doPrint(car));
        System.out.println();
    }

    private static void doPrint(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(DISTANCE_SYMBOL);
        }
        System.out.println();
    }
}
