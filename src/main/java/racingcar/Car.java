package racingcar;

import racingcar.strategy.MovableStrategy;
import racingcar.strategy.RandomMovableStrategy;

public class Car {

    private int position = 0;
    private final String name;
    private final MovableStrategy movableStrategy;

    public Car(String name, MovableStrategy movableStrategy) {
        validateName(name);
        this.name = name;
        this.movableStrategy = movableStrategy;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void move() {
        if (movableStrategy.canMove()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
