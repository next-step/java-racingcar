package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNames {
    private final List<String> carNames;

    public CarNames(String[] inputCarNames) {
        Validator.stringRangeCheck(inputCarNames);
        this.carNames = new ArrayList<>(Arrays.asList(inputCarNames));
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
