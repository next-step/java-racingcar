package race.car;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Car {


    private Car() {
    }


    public static int carMove(int moveDistance, int carMovePower) {
        return moveCarCheck(moveDistance, carMovePower);
    }

    /**
     * 랜덤값을 확인하여 이동거리 +1
     *
     * @param mo0veDistance    이동거리
     * @param inputRandomValue 받은 랜덤한 값
     * @return
     */
    public static int moveCarCheck(int moveDistance, int carPower) {
        if (carPower >= 4) {
            return moveDistance + 1;
        }
        return moveDistance;
    }
}
