package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        if(name.length() < 1) {
            throw new IllegalArgumentException("이름은 최소 1자 이상이어야 합니다.");
        }
        if(name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
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
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
