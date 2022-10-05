package domain;

import java.util.Objects;

public class CarName {

    private final int MAX_CAR_NAME_LENGTH = 5;
    private String name;

    public CarName(String name) {
        if (!isValid(name)) {
            throw new IllegalStateException("자동차 이름은 빈 값이거나 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    private boolean isValid(String name) {
        return name != null && !name.isEmpty() && name.length() < MAX_CAR_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CarName compareCarName = (CarName) obj;
        return name == compareCarName.name;
    }
}
