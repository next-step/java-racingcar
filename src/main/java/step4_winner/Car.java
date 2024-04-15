package step4_winner;

import lombok.Getter;

@Getter
public class Car {
    private int distance = 1;
    private final String name;

    public Car(String inputName) {
        if (inputName.length() > 5)
            throw new IllegalArgumentException("5자를 초과할 수 없습니다");
        this.name = inputName;
    }

    public void move(int randomValue) {
        if (randomValue >= 4)
            distance++;
    }
}
