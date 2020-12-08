package racingcar;

import java.util.Objects;

/**
 * 자동차 이름 클래스
 */
public class CarName {

    private String name;    // 자동차 이름

    public CarName(String name) {
        // 유효성 검사
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
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
        return name != null ? name.hashCode() : 0;
    }
}
