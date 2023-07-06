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
    private final String name;
    private final Moveable moveable;

    public Car(String name, Moveable moveable) {
        preAssert(name, moveable);
        this.position = POSITION_OFFSET;
        this.name = name;
        this.moveable = moveable;
    }

    private void preAssert(String name, Moveable moveable) {
        Asserts.notNull(name, () -> "자동차 이름은 null값이 될 수 없습니다.");
        Asserts.notNull(moveable, () -> "Moveable은 null값이 될 수 없습니다.");
        Asserts.isTrue(name.length() >= NAME_MIN && name.length() <= NAME_MAX,
            () -> "자동차 이름은 1~5자 사이로 입력해야됩니다. 입력한 값: \"" + name + "\"");
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    public void move() {
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
}
