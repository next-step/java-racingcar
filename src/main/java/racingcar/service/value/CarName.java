package racingcar.service.value;

import racingcar.utils.Preconditions;

import java.util.Objects;

public class CarName {
    private static final int CAR_NAME_MAXIMUM_SIZE = 6;

    private final String name;

    private CarName(String name) {
        Preconditions.checkString(name, "name은 필수값입니다.");
        Preconditions.checkMaximumSize(name.length(), CAR_NAME_MAXIMUM_SIZE,
                                       String.format("maximumSize(%d) 값보다 작은 값을 입력해 주세요.", name.length()));

        this.name = name;
    }

    public static CarName from(String name) {
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
