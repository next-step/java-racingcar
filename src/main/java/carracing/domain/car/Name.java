package carracing.domain.car;

import carracing.exception.RacingCarIllegalArgumentException;
import util.StringUtil;

import java.util.Objects;

public class Name {
    private static final int ALLOWED_MAXIMUM_NAME_LENGTH = 5;
    private final String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name from(String name) {
        if (StringUtil.isBlank(name) || name.length() > ALLOWED_MAXIMUM_NAME_LENGTH) {
            throw RacingCarIllegalArgumentException.INVALID_NAME_LENGTH;
        }
        return new Name(name);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
