package racingcar.domain.car;

import java.util.Objects;
import utils.StringUtils;

public class Name {

    private String name;

    public Name(String name) {
        if (StringUtils.isNullOrBlank(name)) {
            throw new IllegalArgumentException("이름값이 있어야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름이 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
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
