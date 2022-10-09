package step3.domain;

import step3.strategy.MovableStrategy;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = 1;
    }

    public void moveOrStop(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
