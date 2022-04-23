package study.step4.utils;

import java.util.Random;

public class RandomNumber {
    private static Random random = new Random(); // 클래스 변수 random
    private static final int BOUND = 10; // 상수

    public static int create() {
        return random.nextInt(BOUND);
    }
}
