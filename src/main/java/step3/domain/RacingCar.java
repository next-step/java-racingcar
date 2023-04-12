package step3.domain;

import step3.exception.RacingCarValidationException;
import step3.move.MoveStrategy;
import step3.move.RandomMoveStrategy;

public class RacingCar {
    protected static final int defaultPosition = 0;
    private static final int maxNameLength = 5;
    private final MoveStrategy moveStrategyStrategy;
    private final String name;

    public RacingCar(final String name, MoveStrategy strategy) {
        this.moveStrategyStrategy = strategy;
        this.name = name;
        this.validate();
    }

    public RacingCar(final String name) {
        this(name, new RandomMoveStrategy());
    }

    public String getName() {
        return name;
    }

    private int position = defaultPosition;

    protected int position() {
        return position;
    }

    protected void resetPosition() {
        position = defaultPosition;
    }

    protected void steeringToForward() {
        position += moveStrategyStrategy.moveAmount();
    }

    private void validate() {
        if (this.name == null) {
            throw new RacingCarValidationException("이름은 null일 수 없습니다");
        }

        if (this.name.length() > maxNameLength) {
            throw new RacingCarValidationException(String.format("이름은 %d글자를 초과할 수 없습니다", maxNameLength));
        }
    }
}
