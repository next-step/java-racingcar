package race.car;

import java.util.List;
import java.util.Random;

public class Car {
    private static Random random = new Random();

    /**
     * 자동차가 이동할 것인지 체크
     * @param paramValue
     *
     * @return
     */
    public static int moveCarCheck(int paramValue) {
        int randomValue = random.nextInt(10);

        if (randomValue >= 4) {
            return paramValue + 1;
        }
        return paramValue;
    }

}
