package racingcar.domain.value;

import java.util.Objects;

public class CarName {

    private final String name;
    private static final int MAX_CAR_NAME = 5;

    private CarName(String name) {

        if(name.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과 할 수 없습니다!!!");
        }

        this.name = name;
    }

    public static CarName create(String name) {

        return new CarName(name);
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
