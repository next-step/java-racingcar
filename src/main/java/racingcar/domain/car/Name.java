package racingcar.domain.car;

import java.util.Objects;
import utils.StringUtils;

public class Name {

    public static final int MAXLENGTH = 5;
    private String name;

    public Name(String name) {
        if (StringUtils.isNullOrBlank(name)) {
            throw new IllegalArgumentException("이름값이 있어야 합니다.");
        }
        if (name.length() > MAXLENGTH) {
            throw new IllegalArgumentException("이름이 " + MAXLENGTH + "자 이하만 가능합니다.");
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
