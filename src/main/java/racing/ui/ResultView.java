package racing.ui;

import java.util.List;
import java.util.stream.Collectors;

import racing.domain.Car;
import racing.domain.CarName;
import racing.domain.Location;

public class ResultView {
    private static final String LOCATION_EXPRESSION_CHARACTER = "-";

    public static void print(final List<Car> cars) {
        for (Car car : cars) {
            print(car);
        }
        System.out.println();
    }

    public static void print(final Car car) {
        final Location carLocation = car.getLocation();

        StringBuilder sb = new StringBuilder();
        sb.append(car.getName().getName())
          .append(" : ");
        Location locationIndex = Location.defaultLocation();
        while (!locationIndex.equals(carLocation)) {
            sb.append(LOCATION_EXPRESSION_CHARACTER);
            locationIndex = locationIndex.forward();
        }
        sb.append(System.lineSeparator());

        System.out.print(sb);
    }

    public static void printWinner(final List<Car> cars) {
        final String winners = cars.stream()
                                   .map(Car::getName)
                                   .map(CarName::getName)
                                   .collect(Collectors.joining(","));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
