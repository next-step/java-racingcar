package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {
    public List<Car> createCars(int carNum) {
        return IntStream.range(0, carNum)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }
}
