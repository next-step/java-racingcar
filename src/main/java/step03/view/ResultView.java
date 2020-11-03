package step03.view;

import step03.Car;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private final String carKind;

    private ResultView(String carKind) {
        this.carKind = carKind;
    }

    public static ResultView of (String carKind) {
        return new ResultView(carKind);
    }

    public void print(Stream<Car> cars) {
        cars.forEach((car) -> {
            String status = IntStream.range(0, car.position())
                    .mapToObj(n -> carKind)
                    .collect(joining(""));
            System.out.println(status);
        });
        System.out.println();
    }

}
