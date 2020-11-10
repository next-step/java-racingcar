package racing.view;

import racing.domain.Cars;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {
    private static final String POSITION = "-";

    private ResultView() {
    }

    public static void printCarPosition(Cars cars) {
        cars.getCarList().stream().forEach(car -> {
            System.out.println(repeat(car.getPosition()));
        });
    }

    private static String repeat(int count) {
        return Stream.generate(() -> POSITION)
                .limit(count)
                .collect(Collectors.joining());
    }
}
