package step4.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("올바른 이름이 아닙니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
