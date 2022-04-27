package study.step4.try2.util;

import java.util.Random;

public class RandomNumber {
    private static final int BOUND = 10; // 상수
    private static final Random random = new Random(); // 클래스 변수 random
    
    public static int create() {
        return random.nextInt(BOUND);
    }
}
