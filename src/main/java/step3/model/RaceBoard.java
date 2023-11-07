package step3.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceBoard {

    private final int cars;

    public RaceBoard(int cars) {
        this.cars = cars;
    }

    public List<Car> generate() {
        return IntStream.range(0, cars).mapToObj(car -> new Car())
                        .collect(Collectors.toList());
    }
}
