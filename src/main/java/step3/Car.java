package step3;

import java.util.Random;

public class Car {

    private static final int MAX_MOVE_LIMIT = 9;
    private static final int MOVE_START_AT = 4;

    private static final Random random = new Random();

    // 구분
    private int carNumber;


    // 위치
    private int location = 1;

    private Car() {
        // CAR_NO = 0;
    }

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    public void move() {
        int movingCnt = random.nextInt(MAX_MOVE_LIMIT);
        location += movingCnt > MOVE_START_AT ? movingCnt : 0;
    }

    public int getLocation() {
        return location;
    }




}
