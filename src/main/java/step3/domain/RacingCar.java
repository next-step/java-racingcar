package step3.domain;

import step3.exception.RacingCarValidationException;
import step3.move.MoveStrategy;
import step3.move.RandomMoveStrategy;

public class RacingCar {
    protected static final Position defaultPosition = new Position(0);

    private static final int maxNameLength = 5;

    private final MoveStrategy moveStrategyStrategy;

    private final Name name;

    private Position position = defaultPosition;


    public RacingCar(final String name, MoveStrategy strategy) {
        this.moveStrategyStrategy = strategy;
        this.name = new Name(name);
        this.validate();
    }

    private void validate() {
        if (this.name == null) {
            throw new RacingCarValidationException("이름은 null일 수 없습니다");
        }

        if (this.name.stringValue().length() > maxNameLength) {
            throw new RacingCarValidationException(String.format("이름은 %d글자를 초과할 수 없습니다", maxNameLength));
        }
    }

    public RacingCar(final String name) {
        this(name, new RandomMoveStrategy());
    }

    public Name getName() {
        return name;
    }

    public boolean isAtPosition(Position position) {
        return this.position.equals(position);
    }

    protected Position position() {
        return position;
    }

    protected void resetPosition() {
        position = defaultPosition;
    }

    protected void steeringToForward() {
        position = new Position(position.intValue() + moveStrategyStrategy.moveAmount());
    }
}
