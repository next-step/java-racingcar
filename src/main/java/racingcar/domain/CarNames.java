package racingcar.domain;

import java.util.Objects;

public class CarNames {
    private static final String DELIMITER = ",";

    private final String[] carNames;

    public CarNames(String carNames) {
        checkNullOrEmpty(carNames);
        this.carNames = carNames.split(DELIMITER);
    }

    private void checkNullOrEmpty(String carNames) {
        if (Objects.isNull(carNames) || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("carNames는 null이거나 empty일 수 없습니다.");
        }
    }

    public String[] getCarNames() {
        return carNames;
    }
}
