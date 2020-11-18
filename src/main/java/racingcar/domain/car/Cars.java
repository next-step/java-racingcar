package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> value;

    public Cars(List<Car> value) {
        this.value = new ArrayList<>(value);
    }

    public List<Car> getValue() {

        return Collections.unmodifiableList(value);
    }

    public List<String> getCarNames() {
        return value.stream().map(car -> car.getName().getValue())
                .collect(Collectors.toList());
    }
}
