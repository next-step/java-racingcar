package study.step4;

import study.step4.exception.CarException;

public class Car {

    private final String name;

    private int position = 1;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    private void validate(String name) {
        if (!isValidName(name)) {
            throw new CarException("CarNameError: 자동차 이름은 1자 이상 5자 입니다.");
        }
    }

    private boolean isValidName(String name) {
        int length = name.length();
        return length >= 1 && length <= 5;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (isForwardCondition(number)) {
            forward();
        }
    }

    private boolean isForwardCondition(int number) {
        return number >= 4;
    }

    private void forward() {
        position += 1;
    }
}
