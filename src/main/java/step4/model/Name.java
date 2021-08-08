package step4.model;

import java.util.Objects;

public class Name {
    private String name;
    public static final int MAX_LENGTH = 5;


    public Name(String name) {
        isOverLength(name);
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    /**
     * 자동차 이름이 5자를 초과하는지 검사한다.
     * @param name
     * @return
     */
    public void isOverLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이상 입력할 수 없습니다.");
        }
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
}
