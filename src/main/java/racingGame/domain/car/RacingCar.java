package racingGame.domain.car;

import racingGame.domain.MovementCondition;

public class RacingCar {
    private Position position;
    private final Name name;
    private final MovementCondition movementCondition;

    public RacingCar(String name, MovementCondition movementCondition) {
        this.position = new Position(0);
        this.name = new Name(name);
        this.movementCondition = movementCondition;
    }

    public RacingCar(String name, Integer position) {
        this(name, (MovementCondition) null);
        this.position = new Position(position);
    }

    public void move() {
        if (movementCondition.canMove()) {
            position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
