package racing;

import java.util.Arrays;
import java.util.Random;

public class Car {

    public static final int MOVE_CONDITION = 4;
    public static final int MAX_RANDOM_NUMBER = 10;

    private int position;
    private String name;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car() {
        this.position = 1;
    }

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = 1;
    }

    public void move() {
        if (isMove(getRandomNumber())) {
            position++;
        }
    }

    public static int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER);
    }

    public static boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }
}
