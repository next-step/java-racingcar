package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarsFactory {
    private static final String DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static Cars createCars(String carNames, MoveChecker moveChecker) {
        validateNonNull(carNames);
        List<String> carNameList = new ArrayList<>();
        for (String carName : carNames.split(DELIMITER)) {
            validateLength(carName);
            carNameList.add(carName);
        }
        return new Cars(carNameList, moveChecker);
    }

    private static void validateNonNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private static void validateLength(final String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}