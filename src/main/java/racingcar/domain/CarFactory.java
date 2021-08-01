package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarFactory {
    private static final String DELIMITER = ",";

    public static List<Car> makeCars(String carNames) {
        checkNullOrEmpty(carNames);
        return Arrays.asList(carNames.split(DELIMITER)).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static void checkNullOrEmpty(String carNames) {
        if (Objects.isNull(carNames) || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("carNames는 null이거나 empty일 수 없습니다.");
        }
    }

}
