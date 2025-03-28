package step4.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
    private static final int MAX_NAME_LENGTH = 5;
    private final List<String> names;

    public CarNames(String input) {
        this.names = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        validateNames();
    }

    public List<String> getNames() {
        return names;
    }

    private void validateNames() {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 하나 이상이어야 합니다.");
        }

        for (String name : names) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 값을 가질 수 없습니다.");
            }
            if (name.trim().length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 최대 " + MAX_NAME_LENGTH + "자 이하이어야 합니다.");
            }
        }
    }
}
