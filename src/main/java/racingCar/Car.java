package racingCar;

import java.util.Random;

public class Car {
    private static final Random random = new Random();
    private final int MOVE_MIN_NUM = 4;
    private final int name;
    private int position;

    public int getPosition() {
        return position;
    }

    public Car(int name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int num) {
        if (num >= MOVE_MIN_NUM) {
            position++;
        }
    }

    public int makeRandomNum() {
        return random.nextInt(10);
    }
}
