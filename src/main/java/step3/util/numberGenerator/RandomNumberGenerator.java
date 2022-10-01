package step3.util.numberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random = new Random();
    private static final int MAX_BOUND_NUMBER = 10;

    @Override
    public int generate(int boundNumber) {
        if(boundNumber > MAX_BOUND_NUMBER) throw new RuntimeException("경주에 필요한 값의 생성 범위를 벗어났습니다.");
        return random.nextInt(boundNumber);
    }
}
