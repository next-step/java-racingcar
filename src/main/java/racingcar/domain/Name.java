package racingcar.domain;

import racingcar.domain.validator.NameValidator;

import java.util.Objects;

public class Name {
    private final String value;

    public Name(String value) {
        NameValidator.validate(value);

        this.value = value.strip();
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
