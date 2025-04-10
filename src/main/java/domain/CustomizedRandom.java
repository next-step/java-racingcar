package domain;

import java.util.Random;

/**
 * 커스텀한 랜덤 클래스
 */
public class CustomizedRandom {
    private final Random random = new Random();
    private static final int CUSTOMIZED_DEFAULT_MIN_BOUND = 4;
    private final int MIN_BOUND;
    private final int MAX_BOUND;

    /**
     * 상한이 있는 랜덤 생성자
     */
    public CustomizedRandom(int maxBound) {
        this(CUSTOMIZED_DEFAULT_MIN_BOUND, maxBound);
    }

    /**
     * 상한과 하한이 있는 랜덤 생성자;
     */
    public CustomizedRandom(int minBound, int maxBound) {
        this.MIN_BOUND = minBound;
        this.MAX_BOUND = maxBound;
    }

    /**
     * 랜덤의 결과값 리턴
     */
    public boolean getResult() {
        return random.nextInt(MAX_BOUND) >= MIN_BOUND;
    }
}
