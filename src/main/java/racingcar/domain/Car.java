package racingcar.domain;

import java.util.Objects;
import racingcar.domain.extension.Moveable;
import racingcar.util.Asserts;

public class Car {

    public static final int MOVE_RULE = 3;
    private static final int NAME_MIN = 1;
    private static final int NAME_MAX = 5;
    private static final int POSITION_OFFSET = 1;

    private int position;
    private final Name name;
    private final Moveable moveable;

    Car(String name, Moveable moveable) {
        Asserts.notNull(moveable, () -> "Moveable은 null값이 될 수 없습니다.");
        this.position = POSITION_OFFSET;
        this.name = new Name(name);
        this.moveable = moveable;
    }

    int getPosition() {
        return this.position;
    }

    String getName() {
        return name.value;
    }

    void move() {
        if (this.moveable.isMove()) {
            this.position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    @Override
    public String toString() {
        return "Car{" +
            "position=" + position +
            ", name='" + name + '\'' +
            ", moveable=" + moveable +
            '}';
    }

    private static final class Name {

        private final String value;

        public Name(String value) {
            Asserts.notNull(value, () -> "자동차 이름은 null값이 될 수 없습니다.");
            Asserts.isTrue(value.length() >= NAME_MIN && value.length() <= NAME_MAX,
                () -> "자동차 이름은 1~5자 사이로 입력해야됩니다. 입력한 값: \"" + value + "\"");
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Name)) {
                return false;
            }
            Name name = (Name) o;
            return Objects.equals(value, name.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Name{" +
                "value='" + value + '\'' +
                '}';
        }
    }

}
