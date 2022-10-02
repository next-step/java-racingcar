package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    public static final String REGEX_COMMA = ",";

    private List<CarName> carNames;

    private CarNames(final List<CarName> carNames) {

        this.carNames = carNames;
    }

    public static CarNames from(final String name) {

        validate(name);
        return new CarNames(split(name));
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

    public List<CarName> list() {

        return this.carNames;
    }
}
