package racingcar.domain;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CarFactory {

    static public Car[] createCars(String namesWithComma) {
        String[] names = namesWithComma.split(",");

        return IntStream.range(0, names.length).mapToObj(i -> new Car(names[i])).toArray(Car[]::new);
    }
}
