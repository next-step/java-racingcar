package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarNames {

    private List<String> carNames;

    private CarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public static CarNames makeCarNames(String[] carNameArray) {
        List<String> carNames = new ArrayList<>(Arrays.asList(carNameArray));
        return new CarNames(carNames);
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }
}
