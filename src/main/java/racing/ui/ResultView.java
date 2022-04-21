package racing.ui;

import java.util.List;

import racing.domain.Car;
import racing.domain.Location;

public class ResultView {
    private static final String LOCATION_EXPRESSION_CHARACTER = "-";

    public static void print(final List<Car> cars) {
        for (Car car : cars) {
            print(car);
        }
        System.out.println();
    }

    public static void print(Car car) {
        final Location carLocation = car.getLocation();

        StringBuilder sb = new StringBuilder();
        sb.append('|');
        Location locationIndex = Location.of();
        while (!locationIndex.equals(carLocation)) {
            sb.append(LOCATION_EXPRESSION_CHARACTER);
            locationIndex = locationIndex.forward();
        }
        sb.append(System.lineSeparator());

        System.out.print(sb);
    }
}
