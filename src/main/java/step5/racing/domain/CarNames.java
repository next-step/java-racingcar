package step5.racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNames {

    private final List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }
}
