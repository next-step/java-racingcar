package step4_winner.domain;

import lombok.Getter;
import step4_winner.strategy.MovingStrategy;

@Getter
public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_DISTANCE = 1;

    private int distance = MIN_DISTANCE;
    private final String name;

    public Car(String inputName) {
        if (inputName.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException("5자를 초과할 수 없습니다");
        this.name = inputName;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) distance++;
    }
}
