package study.racing.domain;

import java.util.List;

public class CarNames {

    private final List<CarName> names;

    public CarNames(List<CarName> names) {
        this.names = names;
    }

    public List<CarName> value() {
        return names;
    }
}
