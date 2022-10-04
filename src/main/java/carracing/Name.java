package carracing;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if(name == null) {
            throw new NullPointerException("NULL은 안돼요!");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이 5 초과 안돼요!");
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
}
