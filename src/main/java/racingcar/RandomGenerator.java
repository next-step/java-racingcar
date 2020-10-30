/**
 * 클래스 이름: RandomGenerator
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

import java.util.Random;

public class RandomGenerator {
    private Random random;

    private RandomGenerator() {
        this.random = new Random();
    }

    public static RandomGenerator getInstance() {
        return SingletonHelper.instance;
    }

    public int getRandomNum() {
        return this.random.nextInt(10);
    }

    private static class SingletonHelper {
        private static final RandomGenerator instance = new RandomGenerator();
    }
}
