package racingCar.car.move;

import java.util.List;

public final class RacingCarMoveServiceLocator {

    private static final int MIN_MOVE_ALLOWED_TRY = 4;

    public RacingCarMoveServiceLocator(List<RacingCarMoveDirectionStrategy> strategies) {
        this.strategies = strategies;
    }

    private final List<RacingCarMoveDirectionStrategy> strategies;

    public RacingCarMoveDirectionStrategy getRacingCarMoveStrategy (int moveAck) {
        RacingCarMoveDirection direction = getDirectionFromMoveAck(moveAck);
        if (direction == null) {
            return null;
        }

        return strategies.stream()
                .filter(strategy -> strategy.getDirection() == direction)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("해당 방식은 지원하지 않습니다. : " + direction.name()));
    }

    private RacingCarMoveDirection getDirectionFromMoveAck(int moveAck) {
        if (moveAck >= MIN_MOVE_ALLOWED_TRY) {
            return RacingCarMoveDirection.FORWARD;
        }

        return null;
    }
}