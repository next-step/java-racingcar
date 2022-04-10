package racing.ui;

import java.text.MessageFormat;
import java.util.List;

import racing.domain.Car;

public class ResultView {

    public static void print(final List<Car> cars) {
        for (Car car : cars) {
            print(car);
        }
        System.out.println();
    }

    public static void print(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(MessageFormat.format("[{0}] ", car.getId()));
        final int location = car.getLocation();
        sb.append("-".repeat(Math.max(0, location)));
        sb.append(System.lineSeparator());
        System.out.print(sb);
    }
}
