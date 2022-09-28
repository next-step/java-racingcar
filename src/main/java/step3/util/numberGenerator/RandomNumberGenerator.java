package step3.util.numberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random = new Random();

    @Override
    public int generate(int maxBound) {
        if(maxBound > 10) throw new RuntimeException("경주에 필요한 값의 생성 범위를 벗어났습니다.");
        return random.nextInt(maxBound);
    }
}
