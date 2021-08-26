package carracing.domain;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class Name {

    private final int NAME_LIMIT_LENGTH = 5;

    private final String name;

    public Name(String name) {
        checkNameBlank(name);
        checkNameLength(name);

        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException("이름은 " + NAME_LIMIT_LENGTH + " 이하여야 합니다.");
        }
    }

    private void checkNameBlank(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름은 공백이 들어올 수 없습니다.");
        }
    }

    public String value() {
        return name;
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
