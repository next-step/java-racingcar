package study.racinggame.domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    public static final String DELIMITER = ",";
    public static final int NUMBER_OF_CARS = 3;

    private final List<Name> names;

    public Names(String carNames) {
        this.names = split(carNames);
    }

    public List<Name> getNames() {
        return names;
    }

    private List<Name> split(String carNames) {
        String[] splitCarNames = carNames.split(DELIMITER);

        if (splitCarNames.length != NUMBER_OF_CARS) {
            throw new IllegalArgumentException("자동차는 3대만 입력 가능합니다.");
        }

        return Arrays.stream(splitCarNames)
                .map(Name::new)
                .collect(Collectors.toList());
    }
}
