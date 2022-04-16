package racingcar.domain.input;

import java.util.Arrays;
import java.util.List;

public class CarCount {

    private static final String CAR_SEPARATOR = ",";
    public static final String INVALID_CAR_NAME_MESSAGE = "최소 하나 이상의 이름을 입력해야합니다.";
    private final int carCount;
    private final List<String> carNames;

    public CarCount(String value) {
        if (isNullOrBlank(value)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
        carNames = Arrays.asList(value.split(CAR_SEPARATOR));
        carCount = carNames.size();
    }

    private boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }

    public int getCount() {
        return this.carCount;
    }
}
