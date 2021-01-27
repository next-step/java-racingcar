package racingcarRefactor.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class CarValidator {
    private static int MAX_CAR_NAME_LENGTH = 5;
    private static String INVALID_CAR_NAME_MESSAGE = "자동차 이름은 5글자가 넘을 수 없습니다.";

    public static void carNameChecker(String carNames) {
        Boolean validNames = Arrays.stream(carNames.split(","))
                .allMatch(name -> name.length() <= MAX_CAR_NAME_LENGTH);

        if (!validNames) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }
}
