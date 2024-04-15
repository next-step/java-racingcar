package step4_winner;

import lombok.Getter;

@Getter
public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;

    private int distance = 1;
    private final String name;

    public Car(String inputName) {
        if (inputName == null || inputName.length() > 5)
            throw new IllegalArgumentException("5자를 초과할 수 없습니다");
        this.name = inputName;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) distance++;
    }
}
