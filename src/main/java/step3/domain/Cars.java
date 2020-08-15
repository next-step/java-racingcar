package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private List<Car> cars;

    public Cars(int carNumber) {
        carSet(carNumber);
    }

    private void carSet(int number) {
        this.cars = Stream.generate(Car::new)
                .limit(number)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
