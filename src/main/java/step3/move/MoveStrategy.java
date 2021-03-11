package step3.move;

/**
 * 이동 조건에 대한 명세 인터페이스
 */
@FunctionalInterface
public interface MoveStrategy {
    boolean isMovable();
}
