package racingcar.domain.car;

import java.util.Arrays;

public class CarNames {
    private static final String SPLIT_REGEX = ",";
    private final String[] parsed;

    public CarNames(final String value) {
        this.parsed = parse(value);
        validate();
    }

    private String[] parse(final String value) {
        return Arrays.stream(value.split(SPLIT_REGEX))
                .map(s -> s.trim())
                .toArray(String[]::new);
    }

    private void validate() {
        if (parsed.length == 0) {
            throw new RuntimeException("자동차 이름이 존재하지 않습니다");
        }
    }

    public String[] getParsed() {
        return Arrays.copyOf(parsed, parsed.length);
    }
}
