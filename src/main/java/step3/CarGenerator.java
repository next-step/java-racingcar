package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGenerator {

    public static List<Car> generate(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
            .mapToObj(i -> new Car())
            .collect(Collectors.toList());
    }

}
