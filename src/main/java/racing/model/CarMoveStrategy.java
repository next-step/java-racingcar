package racing.model;

/**
 * 자동차가 이동하는 규칙을 정의하기 위한 인터페이스
 */
public interface CarMoveStrategy {
    boolean isMovable();
}
