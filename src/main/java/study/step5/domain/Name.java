package study.step5.domain;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        this.validEmpty(name);
        this.validLength(name);

        this.name = name;
    }

    private void validEmpty(String name) {
        if(name == "" || name == null) {
            throw new IllegalArgumentException("공백으로 자동차 이름을 등록할 수 없습니다.");
        }
    }

    private void validLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Name name1 = (Name)o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
