package carracing.domain;

import java.util.Random;

public class Car {
    public static final int CAN_MOVE_VALUE = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move() {
        Random random = new Random();
        int randomValue = random.nextInt(10);

        if(randomValue >= CAN_MOVE_VALUE) {
            position += 1;
        }
    }

    //테스트를 위한 오버로딩ㅠㅠ
    public void move(int randomValue) {
        if(randomValue >= CAN_MOVE_VALUE) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
