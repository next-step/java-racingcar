package racingcar.domain;

import racingcar.util.StringUtil;

public class Car {

    private int position;
    private String name;
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final String CAR_NAME_LENGTH_OVER = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String CAR_NAME_BLANK = "자동차 이름이 공백일 수는 없습니다.";

    public Car() {
        this.position = 0;
    }

    public Car(String name) {
        this.name = validateName(name);
        this.position = 0;
    }

    private String validateName(String name) {
        if (StringUtil.isBlank(name.trim())) {
            throw new IllegalArgumentException(CAR_NAME_BLANK);
        }
        if (name.trim().length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER);
        }
        return name.trim();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(Car car) {
        return this.name.equals(car.getName());
    }
}
