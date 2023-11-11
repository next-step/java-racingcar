package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarName {
    private List<String> carsName;
    private static final String DELIMITER = ",";
    private static final int MAX_CARNAME_LENGTH = 5;


    public CarName(String input) {
        carsName = nameSplit(input);
    }

    private List<String> nameSplit(String input) {
        List<String> names = Arrays.stream(input.split(DELIMITER)).collect(Collectors.toList());
        validateName(names);
        return names;
    }

    private void validateName(List<String> names) {
        names.forEach(carName -> {
            checkMaxLength(carName);
        });
    }

    private static void checkMaxLength(String carName) {
        if (carName.length() > MAX_CARNAME_LENGTH) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public List<String> carNameList() {
        return carsName;
    }
}
