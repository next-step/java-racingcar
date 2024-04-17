package step4_winner.domain;

import lombok.Getter;

@Getter
public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_DISTANCE = 1;
    private static final int MOVE_THRESHOLD = 4;

    private int distance = MIN_DISTANCE;
    private final String name;

    public Car(String inputName) {
        if (inputName.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException("5자를 초과할 수 없습니다");
        this.name = inputName;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) distance++;
    }
}
