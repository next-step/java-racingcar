package step3.domain;

import step3.domain.history.CarHistory;
import step3.service.IntNumberGenerator;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;
    private String name;
    private int position;

    private Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public CarHistory move(IntNumberGenerator generator) {
        if (isMove(generator)) {
            position++;
        }
        return new CarHistory(this);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    private boolean isMove(IntNumberGenerator generator) {
        return generator.generate() >= MOVE_CONDITION;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5자를 초과할 수 없습니다.");
        }
    }
}
