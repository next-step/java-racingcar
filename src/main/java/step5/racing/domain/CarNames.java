package step5.racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNames {

    private final List<CarName> carNames;

    public CarNames(List<String> carNames) {
        this.carNames = createCarNames(carNames);
    }

    private List<CarName> createCarNames(List<String> carNames) {
        List<CarName> names = new ArrayList<>();

        for (String name : carNames) {
            names.add(new CarName(name));
        }
        return names;
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }
}
