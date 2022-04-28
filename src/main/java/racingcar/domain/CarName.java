package racingcar.domain;

import racingcar.exception.CarNameException;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String name) {
        if (name.length() > 5) {
            throw new CarNameException("자동차의 이름은 5글자를 넘을 수 없습니다.");
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
