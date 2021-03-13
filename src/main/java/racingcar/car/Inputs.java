package racingcar.car;

import java.util.Arrays;
import java.util.List;

public class Inputs {
    private List<String> carNames;
    private int forwartCount;

    public Inputs(String carNames, int forwartCount) {
        this.carNames = Arrays.asList(carNames.split(","));
        this.forwartCount = forwartCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getForwartCount() {
        return forwartCount;
    }
}
