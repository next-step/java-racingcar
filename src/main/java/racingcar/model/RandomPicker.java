package racingcar.model;

import java.util.Random;

public class RandomPicker {
    private static final Random random = new Random();

    /**
     * 지정된 최대값을 포함한 범위 내에서 랜덤한 정수를 반환합니다.
     *
     * @param maxInclusive 반환되는 랜덤 정수의 최대값 (포함)
     * @return 범위 내의 랜덤한 정수
     */
    public static int getRandomNumberInRange(int maxInclusive) {
        return random.nextInt(maxInclusive + 1);
    }
}
