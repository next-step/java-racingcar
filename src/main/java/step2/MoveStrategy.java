package step2;

public interface MoveStrategy {
    default boolean isMove() {
        return RacingGameRandomUtils.isMove();
    }

    default Integer getMoveSize() {
        return 1;
    }
}
