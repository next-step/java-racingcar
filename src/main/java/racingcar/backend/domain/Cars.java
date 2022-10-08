package racingcar.backend.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars create(String[] names) {
        return new Cars(Arrays.asList(names).stream()
                .map(name -> Car.create(new CarName(name)))
                .collect(Collectors.toList()));
    }

    public List<Car> getValues() {
        return Collections.unmodifiableList(cars);
    }
}
