package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarName {

    public static final String REGEX_COMMA = ",";

    private final String carName;

    public CarName(final String carName) {

        validate(carName);
        this.carName = carName;
    }

    public static List<CarName> from(final String name) {

        validate(name);
        return split(name);
    }

    private static void validate(final String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 필수값입니다.");
        }
    }

    private static List<CarName> split(final String name) {

        return Arrays.stream(name.split(REGEX_COMMA))
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    public String getCarName() {

        return carName;
    }
}
