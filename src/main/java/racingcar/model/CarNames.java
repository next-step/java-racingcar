package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    private final List<String> carNames;

    public CarNames(String[] inputCarNames) {
        this.carNames = new ArrayList<>();
        for (String carName : inputCarNames) {
            carNames.add(carName);
        }
    }

    public List<String> getCarNames() {
        return this.carNames;
    }

    public String getCarName(int index) {
        return this.carNames.get(index);
    }

    public int getCarNameCount() {
        return this.carNames.size();
    }
}
