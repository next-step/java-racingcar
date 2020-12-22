package step3.domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Cars {

    private List<Car> cars;

    public Cars() {
    }

    public Cars(int createCarCount) {
        registerCar(createCarCount);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void registerCar(int count) {
        cars = Stream.generate(Car::new)
                .limit(count)
                .collect(toList());
    }
}
