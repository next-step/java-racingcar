package racingcar.domain;

import racingcar.Conditions;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }

    public void updateByCondition(int number) {
        isValidate(number);

        if (Conditions.isAcceptCondition(number)) {
            position++;
        }
    }

    public void isValidate(int number) {
        if (Conditions.isInvalidate(number)) {
            throw new IllegalArgumentException("0 ~ 9까지의 값만 사용할 수 있습니다.");
        }
    }
}
