package step3.domain;

import java.util.Random;

/**
 * 랜덤 숫자 생성 클래스
 */
public class RandomGenerator {

    private final Random random;
    private final int bound;

    public RandomGenerator(int bound) {
        this.random = new Random();
        this.bound = bound;
    }

    // 랜덤 숫자 생성기 (1 ~ bound)
    public int generateOneToTen() {
        return random.nextInt(bound);
    }
}
