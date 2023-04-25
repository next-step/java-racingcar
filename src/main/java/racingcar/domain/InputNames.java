package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class InputNames {
    public static final String DELIMITER = ",";
    private final List<String> carNames = new ArrayList<>();

    public InputNames(String names) {
        splitCarName(names);
    }

    private void splitCarName(String names) {
        String[] name = names.split(DELIMITER);
        for (String s : name) {
            carNames.add(s.trim());
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
