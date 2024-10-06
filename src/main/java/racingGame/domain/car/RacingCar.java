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
        this.position = new Position(position);
        this.name = new Name(name);
        this.movementCondition = null;
    }

    public void move() {
        if (movementCondition.canMove()) {
            position.move();
        }
    }

    public int getPositionValue() {
        return position.getPosition();
    }

    public String getNameValue() {
        return name.getName();
    }
}
