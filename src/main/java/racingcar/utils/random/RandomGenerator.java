package racingcar.utils.random;

import java.util.Random;

/**
 * 랜덤 값을 생성한다.
 */
public class RandomGenerator {

    /**
     * 0 이상 10 미만의 정수 랜덤값을 생성한다.
     *
     * @return 생성된 랜덤값
     */
    public static int extractRandomSingleDigit() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
