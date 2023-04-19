package racingcar.domain;

import java.util.Objects;

public class CarName {

    public static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        if(name.length() > MAX_LENGTH) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
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
