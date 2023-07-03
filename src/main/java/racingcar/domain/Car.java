package racingcar.domain;

import java.util.Objects;
import racingcar.domain.extension.Moveable;

public class Car {

    private int position;
    private final String name;
    private final Moveable moveable;

    public Car(String name, Moveable moveable) {
        preAssert(name);
        this.position = 1;
        this.name = name;
        this.moveable = moveable;
    }

    private void preAssert(String name) {
        assertNotNull(name);
        assertNameLength(name);
    }

    private void assertNameLength(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이로 입력해야됩니다. 입력한 값: \"" + name + "\"");
        }
    }

    private void assertNotNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("자동차 이름은 null값이 될 수 없습니다.");
        }
    }

}
