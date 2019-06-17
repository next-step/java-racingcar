package step2;

public interface MoveStrategy {
    default boolean isMove() {
        return RacingGameRandomUtils.isMove();
    }
}
