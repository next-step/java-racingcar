package step_3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarFactory {
    private CarFactory() {
    }

    public static List<Car> produce(int toProduceCarCount) {
        return IntStream.range(0, toProduceCarCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

}
