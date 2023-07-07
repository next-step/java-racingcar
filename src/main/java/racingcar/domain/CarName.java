package racingcar.domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5 이하여야 합니다.");
        }
    }

    private void validateEmpty(String carName) {
        if (carName == null || carName.isBlank()){
            throw new IllegalArgumentException("유효하지 않은 입력입니다. 다시 입력해주세요");
        }
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

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }
}
