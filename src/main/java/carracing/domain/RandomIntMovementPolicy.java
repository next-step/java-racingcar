package carracing.domain;


import carracing.util.RandomGenerator;

/**
 * 랜덤 값이 기준값에 따라 전진이 가능한 정책을 정의한 클래스
 */
public class RandomIntMovementPolicy implements MovementPolicy {

    public static final int RANDOM_BOUND_NUMBER = 10;
    public static final int BASE_POSITION_NUMBER = 4;
    public static final int MAX_POSITION_NUMBER = 9;
    public static final int MIN_POSITION_NUMBER = 0;
    private final RandomGenerator randomGenerator;

    public RandomIntMovementPolicy(RandomGenerator randomGenerator) {
        validateRandomGenerator(randomGenerator);
        this.randomGenerator = randomGenerator;
    }

    private void validateRandomGenerator(RandomGenerator randomGenerator) {
        if (randomGenerator == null) {
            throw new IllegalArgumentException("자동차 전진 정책에는 랜덤 생성기가 지정되어야합니다.");
        }
    }

    @Override
    public boolean isMovable() {
        int randomInt = randomGenerator.generateZeroOrPositiveNumber(RANDOM_BOUND_NUMBER);
        return randomInt >= BASE_POSITION_NUMBER;
    }
}
