package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> value;

    public Cars() {
        this(new ArrayList<>());
    }

    public Cars(List<Car> value) {
        this.value = value;
    }

    public List<Car> getValue() {
        return value;
    }

    public List<String> getCarNames() {
        return value.stream().map(car -> car.getName().getValue())
                .collect(Collectors.toList());
    }
}
