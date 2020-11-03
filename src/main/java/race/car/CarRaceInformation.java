package race.car;

import java.util.List;
import java.util.Random;

/**
 * 자동차 게임의 정보를 관리하는 객체
 */
public class CarRaceInformation {

    private int[] carMoveCountArr; // 자동차 갯수에따른 이동정보
    private int carCount; // 자동채 댓수
    private int tryCount; // 이동 시도횟수

    CarRaceInformation(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        this.carMoveCountArr = new int[carCount];
    }

    public int[] getCarMoveCountArr() {
        return carMoveCountArr;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
