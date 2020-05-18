package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String carNames) {
        String[] names = carNames.split(",");

        List<Car> collect = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(collect);
    }
}
