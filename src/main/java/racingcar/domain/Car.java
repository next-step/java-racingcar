package racingcar.domain;

import racingcar.domain.extension.Moveable;
import racingcar.util.Asserts;

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
        Asserts.notNull(name, () -> "자동차 이름은 null값이 될 수 없습니다.");
        Asserts.notNull(moveable, () -> "Moveable은 null값이 될 수 없습니다.");
        Asserts.isTrue(name.length() > 0 && name.length() < 6,
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
}
