package step3.domain;

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

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public Car move(IntNumberGenerator generator) {
        if (isMove(generator)) {
            position++;
        }
        return copy(this);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private Car copy(Car car) {
        return new Car(car.getName(), car.getPosition());
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
