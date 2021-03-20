package step4.domain.car.name;

import java.util.Objects;

public final class Name {
    private final int STANDARD = 5;
    private final String name;

    public Name(String name) {
        if(isInvalid(name)) {
            throw new IllegalArgumentException("유효하지 않은 이름을 사용했습니다.");
        }
        this.name = name;
    }

    private final boolean isInvalid(String name) {
        return name.length() > STANDARD;
    }

    public final String name() {
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
