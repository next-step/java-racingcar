package step5.racingcar3.domain;

import java.util.List;

public class CarNameList {

    private final List<CarName> value;

    public CarNameList(List<CarName> carNames) {
        this.value = carNames;
    }

    public List<CarName> value() {
        return value;
    }

}
