package racing.domain;
import java.util.Objects;

public class Name {
    private final String name;
    private static final int MAX_NAME_LENGTH = 5;

    public Name(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력하세요.");
        }
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 다섯자 초과");
        }
        this.name = name;
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
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
