package racingcar.validator;

import java.util.Arrays;

public class InputValidator {

    private static final String REGEX_COMMA = ",";
    private static final int CAR_NAME_MAXIMUM_LENGTH = 5;
    private static final String ERROR_MESSAGE_OVER_SIZE_CAR_NAME = "자동차 이름이 사이즈를 초과했습니다.";

    public static void validate(String carNameList) {
        Arrays.stream(carNameList.split(REGEX_COMMA))
                .forEach(v -> {
                    if (v.length() > CAR_NAME_MAXIMUM_LENGTH)
                        throw new IllegalArgumentException(ERROR_MESSAGE_OVER_SIZE_CAR_NAME);
                });
    }
}
