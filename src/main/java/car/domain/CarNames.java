package car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class CarNames {

    private List<CarName> names;
    private final String CAR_NAMES_DELIMITER = "\\s+|,\\s*";
    private final int ZERO = 0;

    public CarNames(String names) {
        List<CarName> carNames = validateCarNames(names);
        this.names = carNames;
    }

    private List<CarName> validateCarNames(String names) {
        if (names == null || names.isBlank()) {
            throw new RuntimeException();
        }

        String[] tokenCarNames = tokenCarNames(names);
        if (tokenCarNames.length == ZERO) {
            throw new RuntimeException();
        }

        return Arrays.stream(tokenCarNames).map(CarName::new).collect(Collectors.toList());
    }

    private String[] tokenCarNames(String carNames) {
        return carNames.split(CAR_NAMES_DELIMITER);
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(names);
    }
}
