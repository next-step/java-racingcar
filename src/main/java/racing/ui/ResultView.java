package racing.ui;

import java.util.List;

import racing.domain.Car;

public class ResultView {
    private static final String LOCATION_EXPRESSION_CHARACTER = "-";

    public static void print(final List<Car> cars) {
        for (Car car : cars) {
            print(car);
        }
        System.out.println();
    }

    public static void print(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append('|')
          .append(LOCATION_EXPRESSION_CHARACTER.repeat(Math.max(0, car.getLocation())))
          .append(System.lineSeparator());
        System.out.print(sb);
    }
}
