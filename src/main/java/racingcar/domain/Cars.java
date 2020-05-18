package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

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

    public void carRacing(Strategy strategy) {
        cars.forEach(car -> {
            int randomNumber = strategy.getNumber();
            car.move(randomNumber);
        });
    }
}
