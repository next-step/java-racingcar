package racingcar;

import java.util.Random;

public class Car {
    //이동기능, 이동거리 기록
//값이 랜덤 값이 4이상일때 이동가능.

    private int movingDistance = 0;

    public int getMovingDistance() {
        return movingDistance;
    }

    public void moveCar() {
        movingDistance++;
    }


}
