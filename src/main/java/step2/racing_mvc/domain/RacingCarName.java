package step2.racing_mvc.domain;

import java.util.Objects;

public class RacingCarName {
    private final int NAME_MAX_LENGTH = 5;
    private final String name;

    public RacingCarName(String carName) {
        validateNameLength(carName);
        name = carName;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarName carName = (RacingCarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}