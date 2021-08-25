package carracing.domain;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class Name {

    private final String name;

    public Name(String name, int limitLength) {
        checkNameBlank(name);
        checkNameLength(name, limitLength);

        this.name = name;
    }

    private void checkNameLength(String name, int limitLength) {
        if (name.length() > limitLength) {
            throw new IllegalArgumentException("이름은 " + limitLength + " 이하여야 합니다.");
        }
    }

    private void checkNameBlank(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름은 공백이 들어올 수 없습니다.");
        }
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
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
