package step3.domain;

import java.util.Objects;

public class CarName {
    private final String value;

    public CarName(String value) {
        checkString(value);
        checkLength(value);
        this.value = value;
    }


    private void checkLength(String carName) {
        if (carName.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void checkString(String carName) {
        if (Objects.isNull(carName) || carName.isBlank()) {
            throw new RuntimeException("올바르지 않은 문자열 입니다.");
        }
    }

    public String value() {
        return value;
    }
}
