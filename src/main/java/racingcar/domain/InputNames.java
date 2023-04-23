package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class InputNames {
    public static final String DELIMITER = ",";
    private List<String> carNames = new ArrayList<>();

    public InputNames(String names) {
        splitCarName(names);
    }

    private void splitCarName(String names) {
        String[] name = names.split(DELIMITER);
        for (int i = 0; i < name.length; i++) {
            carNames.add(name[i].trim());
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
