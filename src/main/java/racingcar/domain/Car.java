package racingcar.domain;

import racingcar.domain.utils.Number;

public class Car {
    private String name;
    private int place;
    private MovingStrategy movingStrategy;

    public Car(String name, MovingStrategy movingStrategy) {
        this.name = name;
        this.place = 0;
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
        this.place = 0;
    }

    private boolean isSupportFormat(String name) {
        return name.length() <= 5;
    }

    private boolean isBlank(String name) {
        return name == null || name.trim().isEmpty();
    }

    public int getPlace() {
        return this.place;
    }

    public String getName() {
        return this.name;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.place++;
        }
    }
}
