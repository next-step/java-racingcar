package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String names) {
        this(names.split(DELIMITER));
    }

    public Cars(String[] names) {
        this(Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(MoveStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }
    
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
