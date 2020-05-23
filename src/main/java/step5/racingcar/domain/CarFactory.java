package step5.racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> makeCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }
}
