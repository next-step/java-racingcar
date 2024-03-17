package race.domain;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Name))
            return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
