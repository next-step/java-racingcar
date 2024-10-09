package racing.car.model;

import java.util.Objects;

public class CarName {
    private static final String OVER_MESSAGE_ERROR = "자동차 이름이 5자글자를 초과하였습니다.";
    private static final int NAME_LIMIT_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        check(name);
        this.name = name;
    }

    private void check(String name) {
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(OVER_MESSAGE_ERROR);
        }
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
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
