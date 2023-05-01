package car_racing;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차의 이름은 값이 존재해야 합니다.");
        }
        if (CarUtil.isExceed5Characters(name)) {
            throw new IllegalArgumentException("자동차의 이름은 5를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
