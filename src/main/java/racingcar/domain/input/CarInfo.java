package racingcar.domain.input;

import racingcar.domain.exception.InvalidCarNameException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarInfo {

    private static final String CAR_SEPARATOR = ",";
    private final List<CarName> carNames;

    public CarInfo(String value) {
        if (isNullOrBlank(value)) {
            throw new InvalidCarNameException();
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
