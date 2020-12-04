package step5.util;

import java.util.Random;

public class Util {
    private static Random random = new Random();

    /**
     * 0에서 9사이의 랜덤값을 생성하는 메소드
     * @return 랜덤값
     */
    public static int getRandomNumber() {
        return random.nextInt(Constants.RANDOM_RANGE);
    }
}
