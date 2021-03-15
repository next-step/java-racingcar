package step5.domain;

import java.util.Objects;

public class Name {

    public static final int MAX_NAME = 4;

    private final String name;

    public Name(String name) {
        emptyValid(name);
        sizeValid(name);

        this.name = name;
    }

    private void emptyValid(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("공백은 사용할수 없습니다");
        }
    }

    private void sizeValid(String name) {
        if (name.length() > MAX_NAME ) {
            throw new IllegalArgumentException("5자 이상 문자열을 사용할수 없습니다.");
        }
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
}
