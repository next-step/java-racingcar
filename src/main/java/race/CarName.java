package race;

import java.util.Objects;

public class CarName {
    private final String name;
    private static final int MAX_LENGTH = 5;

    public CarName(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("CarName의 최대 길이를 초과했습니다.");
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (name.equals(o)) return true;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
