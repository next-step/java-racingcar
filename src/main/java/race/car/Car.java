package race.car;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Car {

    private static Random random = new Random();

    /**
     * 랜덤값 return
     * @return
     */
    public static int getMovePower() {
        return random.nextInt(10);
    }

    /**
     * 랜덤값을 확인하여 이동거리 +1
     *
     * @param moveDistance     이동거리
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
