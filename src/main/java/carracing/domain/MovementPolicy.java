package carracing.domain;

/**
 * 자동차 경주에 필요한 정책 인터페이스
 */
@FunctionalInterface
public interface MovementPolicy {
    boolean isMovable();
}
