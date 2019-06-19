package racing.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarFactory {

    public static List<Car> createByCount(int count) {
        return IntStream.of(count).boxed().map(e -> new Car()).collect(Collectors.toList());
    }
}
