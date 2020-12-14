package racingcar.domain;

import java.util.List;

public class CarNames {

    private final List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public List<CarName> getCarNames() {
        return carNames;
    }

    public CarName getCarName(int index) {
        return carNames.get(index);
    }

    public int size() {
        return carNames.size();
    }
}
