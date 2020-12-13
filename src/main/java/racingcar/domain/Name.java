package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        this.name = validateName(name);
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

    public String getName() {
        return this.name;
    }

    /**
     * 이름의 길이 값을 검증
     * @param name
     * @return
     */
    private String validateName(String name) {
        if(name != null && name.length() <= Name.NAME_MAX_LENGTH) {
            return name;
        }
        throw new IllegalArgumentException("이름의 길이가 적절하지 않습니다.");
    }
}
