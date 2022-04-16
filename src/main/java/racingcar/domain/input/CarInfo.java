package racingcar.domain.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarInfo {

    private static final String CAR_SEPARATOR = ",";
    private static final String INVALID_CAR_NAME_MESSAGE = "최소 하나 이상의 이름을 입력해야합니다.";
    private final List<CarName> carNames;

    public CarInfo(String value) {
        if (isNullOrBlank(value)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
        carNames = Arrays.asList(value.split(CAR_SEPARATOR))
                .stream()
                .map(carName -> new CarName(carName))
                .collect(Collectors.toList());
    }

    private boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }

    public List<CarName> getCarNames() {
        return carNames;
    }
}
