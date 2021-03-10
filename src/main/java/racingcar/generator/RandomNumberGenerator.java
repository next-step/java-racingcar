package racingcar.generator;

import java.util.Random;

// 단순히 static 성질만 가진 Util 클래스로 만들지,
// 아니면 인스턴스 멤버를 가진 싱글턴 인스턴스로 만들지 고민이 됩니다.
public class RandomNumberGenerator {

    private static final Random random = new Random();
    private static final int LIMIT = 10;

    private static RandomNumberGenerator instance;

    private RandomNumberGenerator() { }

    public static RandomNumberGenerator getInstance() {
        if (instance == null) {
            instance = new RandomNumberGenerator();
        }
        return instance;
    }

    public int generateRandomNumber() {
        return random.nextInt(LIMIT);
    }

}
