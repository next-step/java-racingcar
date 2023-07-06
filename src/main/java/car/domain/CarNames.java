package car.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class CarNames {

    private final List<CarName> names;
    private final static String CAR_NAMES_DELIMITER = ",";
    private final static int ZERO = 0;

    public CarNames(final String names) {
        validateCarNames(names);
        this.names = Arrays.stream(tokenCarNames(names))
            .map(CarName::new)
            .collect(Collectors.toList());
    }

    private void validateCarNames(final String names) {
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException("자동차 입력이 공백이거나 NULL 값 입니다.");
        }

        String[] tokenCarNames = tokenCarNames(names);
        if (tokenCarNames.length == ZERO) {
            throw new IllegalArgumentException("자동차 입력이 공백이거나 NULL 값 입니다.");
        }
    }

    private String[] tokenCarNames(final String carNames) {
        return carNames.split(CAR_NAMES_DELIMITER);
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(names);
    }
}
