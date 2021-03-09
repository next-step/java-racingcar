package study.step3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> car) {
        this.cars = car;
    }

    public int getCarSize() {
        return cars.size();
    }

    public static Cars of(int carNumber) {
        return new Cars(Arrays.stream(new int[carNumber])
                .mapToObj(car -> Car.of())
                .collect(Collectors.toList())
        );
    }
}
