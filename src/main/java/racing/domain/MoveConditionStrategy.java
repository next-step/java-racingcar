package racing.domain;

public interface MoveConditionStrategy {
    int getMoveChangeCondition();

    boolean isMovable();
}
