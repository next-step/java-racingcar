package step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarNames {
    public static final String NAME_SEPARATOR = ",";

    List<String> carNames;

    public CarNames(String inputNames) {
        this.carNames = ArrayToList(StringToArray(inputNames));
    }

    private List<String> ArrayToList(String[] testCarNames) {
        return new ArrayList<>(Arrays.asList(testCarNames));
    }

    private String[] StringToArray(String testCarNames) {
        return testCarNames.split(NAME_SEPARATOR);
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }
}
