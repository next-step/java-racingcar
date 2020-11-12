package racingcar.domain;

import racingcar.domain.utils.Number;

public class Car {
    private String name;
    private String place;
    private MovingStrategy movingStrategy;

    public Car(String name, MovingStrategy movingStrategy) {
        this.name = name;
        this.place = "";
        this.movingStrategy = movingStrategy;
    }

    public Car(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름 형식이 잘못 되었습니다.");
        }
        
        if (!isSupportFormat(name)) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }

        this.name = name;
    }

    private boolean isSupportFormat(String name) {
        return name.length() <= 5;
    }

    private boolean isBlank(String name) {
        return name == null || name.trim().isEmpty();
    }

    public String getPlace() {
        return this.place;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        if (this.movingStrategy.move() >= Number.NEED_NUMBER) {
            movePlace();
        }
    }

    private void movePlace() {
        this.place += new StringBuilder().append('-');
    }
}
