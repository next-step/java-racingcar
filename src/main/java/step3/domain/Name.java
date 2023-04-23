package step3.domain;

import step3.exception.RacingCarValidationException;

public class Name {
    private final String name;

    public Name(final String name) {
        if (name == null) throw new RacingCarValidationException("이름은 null일 수 없습니다");

        this.name = name;
    }

    public String stringValue() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
