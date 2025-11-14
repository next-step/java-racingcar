import java.util.Objects;

public class CarName {
    private final String name;

    CarName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    private boolean isValidName(String name) {
        return name.length() <= 5;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
