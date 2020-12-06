package carracing.domain;

/**
 * 랜덤 값이 기준값에 따라 전진이 가능한 정책을 정의한 클래스
 */
public class RandomIntMovementPolicy implements MovementPolicy {

    private static final int POLICY_BASE_NUMBER = 4;
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
        int randomInt = randomGenerator.generateZeroToNineInt();
        return randomInt >= POLICY_BASE_NUMBER;
    }
}
