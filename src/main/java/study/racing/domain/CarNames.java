package study.racing.domain;

import java.util.Arrays;
import java.util.List;

public class CarNames {

    private final List<CarName> names;

    public CarNames(String names) {
        this(names.split(","));
    }

    public CarNames(String[] names) {
        this(Arrays.stream(names)
                .map(CarName::new)
                .toList());
    }


    public CarNames(List<CarName> names) {
        this.names = names;
    }

    public List<CarName> value() {
        return names;
    }
}
