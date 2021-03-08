package step3.domain;

import java.util.Random;

/**
 * 랜덤 숫자 생성 클래스
 */
public class RandomGenerator {

    // 랜덤 BOUND 설정
    public static final int RANDOM_RANGE_BOUND = 10;

    private final Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    // 랜덤 숫자 생성기 (1 ~ bound)
    public int generateOneToTen(int bound) {
        return random.nextInt(bound);
    }
}
