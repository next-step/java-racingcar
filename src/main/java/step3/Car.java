package step3;

import java.util.Random;

public class Car {


    private static final int MAX_MOVE_LIMIT = 9;
    private static final int MOVE_START_AT = 4;

    private static final Random random = new Random();

    // 구분
    private int CAR_NO;
    // 위치
    private int location = 0;

    private Car() {
        // CAR_NO = 0;
    }

    public Car(int car_no) {
        CAR_NO = car_no;
    }

    public void move() {

        int movingCnt = random.nextInt(MAX_MOVE_LIMIT);
        location += movingCnt > MOVE_START_AT ? movingCnt : 0;

    }

    public void printCurrentLocation() {
        //System.out.print(CAR_NO);
        System.out.println(new String(new char[location]).replace("\0", "-"));
    }


}
