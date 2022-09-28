package racingcar.strategy;

public class MovingStrategyFactory {
    public static MovingStrategy getInstance(MovingStrategyType type) {
        if (type.equals(MovingStrategyType.RANDOM)) {
            return new RandomMovingStrategy();
        }
        throw new IllegalArgumentException("유효하지 않은 MovingStrategyType 입니다.");
    }
}
