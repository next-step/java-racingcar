package racingcar.domain;

import java.util.Objects;
import racingcar.domain.extension.Moveable;

public class Car {

    private int position;
    private final String name;
    private final Moveable moveable;

    public Car(String name, Moveable moveable) {
        preAssert(name, moveable);
        this.position = 1;
        this.name = name;
        this.moveable = moveable;
    }

    private void preAssert(String name, Moveable moveable) {
        assertNameIsNotNull(name);
        assertMoveableIsNotNull(moveable);
        assertNameLength(name);
    }

    private void assertNameIsNotNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("자동차 이름은 null값이 될 수 없습니다.");
        }
    }

    private void assertMoveableIsNotNull(Moveable moveable) {
        if (Objects.isNull(moveable)) {
            throw new IllegalArgumentException("Moveable은 null값이 될 수 없습니다.");
        }
    }

    private void assertNameLength(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이로 입력해야됩니다. 입력한 값: \"" + name + "\"");
        }
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (this.moveable.isMove()) {
            this.position++;
        }
    }
}
