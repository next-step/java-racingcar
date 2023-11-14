package step4.model;

import java.util.Objects;

public class Car {

    private final static int MAXIMAL_NAME_LENGTH = 5;

    private final String name;

    private Moving moving;

    public Car(String name, Moving moving) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("자동차 이름은 " + MAXIMAL_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.name = name.trim();
        this.moving = moving;
    }

    private boolean isValidName(final String name) {
        return Objects.nonNull(name) && name.length() <= MAXIMAL_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    public void move(NumberGenerator generator, String movingStr) {
        moving.move(generator);
    }

    public Moving getMoving() {
        return moving;
    }

}
