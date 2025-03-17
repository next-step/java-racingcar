package race;

import java.util.Random;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(10); // 0~9 사이 랜덤 값 생성
    }
}
