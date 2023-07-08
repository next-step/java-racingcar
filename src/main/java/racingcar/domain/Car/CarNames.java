package racingcar.domain.Car;

import java.util.Arrays;

public class CarNames {
    private final String carNames;

    public CarNames(final String value) {
        validate(value);
        this.carNames = value;
    }

    private void validate(final String value) {
        if (value.split(",").length == 0) {
            throw new RuntimeException("자동차 이름이 존재하지 않습니다");
        }
    }

    public String[] parse() {
        return Arrays.stream(carNames.split(","))
                .map(s -> s.trim())
                .toArray(String[]::new);
    }
}
