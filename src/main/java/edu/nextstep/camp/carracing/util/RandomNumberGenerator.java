package edu.nextstep.camp.carracing.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int DEFAULT_BOUND = 10;
    private static final Random random = new Random();

    private RandomNumberGenerator() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static int generateRandomNumber() {
        return random.nextInt(DEFAULT_BOUND);
    }
}
