package step4.domain.driver.name;

import step4.domain.startegy.name.NamingStrategy;

import java.util.Objects;

public class Name {

    private String name;

    private Name(String name, NamingStrategy namingStrategy) {
        if (isNotValidate(name, namingStrategy))
            throw new IllegalArgumentException("이름에 사용되기에는 알맞은 값이 아닙니다.");
        this.name = name;
    }

    public static Name from(String name, NamingStrategy lengthCheck) {
        return new Name(name, lengthCheck);
    }

    private boolean isNotValidate(String name, NamingStrategy lengthCheck) {
        return (!(lengthCheck.isValidate(name)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

}

