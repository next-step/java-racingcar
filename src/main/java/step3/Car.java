package step3;

import java.util.Random;

public class Car implements CarInterface {

    // 구분
    int carNumber;

    // 위치
    int location = 1;

    private Car() {
    }

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    public void move() {
        int movingCnt = getMoveCount();
        location = (movingCnt > MOVE_START_AT) ? location + movingCnt : location;
    }

    @Override
    public int getMoveCount() {
        return random.nextInt(MAX_MOVE_LIMIT);
    }

    public int getLocation() {
        return location;
    }


}
