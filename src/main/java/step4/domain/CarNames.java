package step4.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarNames {
    private static final String NAME_SEPARATOR = ",";

    private List<String> carNames;

    public CarNames(String inputNames) {
        if (StringUtils.isEmpty(inputNames)) {
            throw new IllegalArgumentException("자동차 이름들을 입력하세요.");
        }
        this.carNames = ArrayToList(StringToArray(inputNames));
    }

    public static CarNames from(String inputNames) {
        return new CarNames(inputNames);
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
