package race.domain;

import java.util.Objects;

public class Name {

    private static final int LENGTH_STANDARD = 5;
    private final String name;

    public Name(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
        if (name.length() > LENGTH_STANDARD)
            throw new IllegalArgumentException("자동차 이름의 길이는 5 이하여야 합니다.");
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

    public String getName() {
        return this.name;
    }
}
