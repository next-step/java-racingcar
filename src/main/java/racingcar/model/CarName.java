package racingcar.model;

import java.util.Objects;

public final class CarName {
    public static final int MAX_LENGTH = 5;
    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName from(String name) {
        validate(name);
        return new CarName(name);
    }

    private static void validate(String name) {
        Objects.requireNonNull(name, "자동차 이름은 null 일 수 없습니다");

        if (name.isBlank()) {
            throw new IllegalArgumentException(String.format("자동차 이름은 빈 값일 수 없습니다 : %s", name));
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 글자수는 5자를 넘을 수 없습니다. : %s", name));
        }
    }

    public String get() {
        return name;
    }
}
