package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(int carNo) {
        List<Car> carsList = IntStream.range(0, carNo)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
        return new Cars(carsList);
    }

    public List<Car> getCars() {
        return cars;
    }
}
