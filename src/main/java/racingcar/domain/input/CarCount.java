package racingcar.domain.input;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarCount {

    private static final String CAR_SEPARATOR = ",";
    private static final String INVALID_CAR_NAME_MESSAGE = "최소 하나 이상의 이름을 입력해야합니다.";
    private final List<String> carNames;

    public CarCount(String value) {
        if (isNullOrBlank(value)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
        carNames = Arrays.asList(value.split(CAR_SEPARATOR));
    }

    private boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
