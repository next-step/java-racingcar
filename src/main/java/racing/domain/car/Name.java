package racing.domain.car;

import java.util.Objects;

public class Name {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    final String value;

    public Name(String value) {
        checkNameLength(value);
        this.value = value;
    }

    public Name(Name value) {
        this(value.getValue());
    }

    private static void checkNameLength(final String value) {
        if (value.length() < CAR_NAME_MIN_LENGTH || value.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(
                "[ERROR] 이름의 길이는 " + CAR_NAME_MIN_LENGTH + " ~ " + CAR_NAME_MAX_LENGTH
                    + " 글자 까지만 가능합니다.");
        }
    }

    public String getValue() {
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
