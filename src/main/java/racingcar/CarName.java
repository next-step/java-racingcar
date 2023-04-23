package racingcar;

import java.util.Objects;

public class CarName {

    private final String name;
    private final int MAX_LENGTH = 5;

    public CarName(String name) {
        this.name = name;
        validateNameBlank();
        validateLengthGrateThen();
    }

    public String getName() {
        return name;
    }

    private boolean isGrateThen() {
        return this.name.length() > MAX_LENGTH;
    }

    private void validateNameBlank() {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateLengthGrateThen() {
        if (isGrateThen()) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;

        CarName carName = (CarName) o;

        if (MAX_LENGTH != carName.MAX_LENGTH) return false;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
