package racingcar.domain;

import java.util.Objects;

public class CarName {
    private String name;

    public CarName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("이름은 5글자를 초과할 수 없습니다.");
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
        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
