package carracing.domain;

import java.util.Random;

public class Car {
    private static final int MIN_MOVE_VALUE = 4;
    private static final int INITIAL_POSITION = 1;
    private static final Random RANDOM = new Random();
    private int position;

    public Car() {
        this.position = INITIAL_POSITION;
    }

    public void move() {
        int randomValue = RANDOM.nextInt(10);
        if (randomValue >= MIN_MOVE_VALUE) {
            position += 1;
        }
    }

    //테스트를 위한 오버로딩ㅠㅠ
    public void move(int randomValue) {
        if (randomValue >= MIN_MOVE_VALUE) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
