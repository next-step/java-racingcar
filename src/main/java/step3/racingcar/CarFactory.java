package step3.racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> makeCars(int carCounts) {
        return Stream.generate(Car::new)
                .limit(carCounts)
                .collect(Collectors.toList());
    }
}
