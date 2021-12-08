package carracing.domain;

import java.util.Objects;

/**
 * 자동차의 이름을 저장하는 클래스
 */
public class CarName {
    public static final int MIN_NAME_SIZE = 1;
    public static final int MAX_NAME_SIZE = 5;

    private final String name;

    public CarName(String name) {
        validateName(name);
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

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차의 이름이 입력되어야합니다.");
        }
        if (isInvalidName(name)) {
            throw new IllegalArgumentException("자동차의 이름은 " + MIN_NAME_SIZE + "이상 " + MAX_NAME_SIZE + "이하 글자가 입력되어야합니다.");
        }
    }

    private boolean isInvalidName(String name) {
        int nameLength = name.length();
        return nameLength < MIN_NAME_SIZE || nameLength > MAX_NAME_SIZE;
    }
}
