package step3.move;

import step3.random.NumberGenerator;
import step3.random.RandomNumberGenerator;

/**
 * 자동차의 이동을 판단하기 위한 조건을 결정하는 클래스
 */
public class ConditionMoveStrategy implements MoveStrategy {

    private static final int STANDARD_NUMBER = 4;

    private final NumberGenerator numberStrategy;

    // default 전략은 RandomNumber
    public ConditionMoveStrategy() {
        this(new RandomNumberGenerator());
    }

    // 인터페이스를 파라미터로 설정, 구현체를 파라미터로 받아 생성
    public ConditionMoveStrategy(NumberGenerator numberStrategy) {
        this.numberStrategy = numberStrategy;
    }

    @Override
    public boolean isMovable() {
        return numberStrategy.generate() >= STANDARD_NUMBER;
    }
}
