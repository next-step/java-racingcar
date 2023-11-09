package racingcar.domain.car;

import racingcar.domain.game.strategy.MoveStrategy;

public class Car {

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getCarName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position = this.position.move();
        }
    }

    public boolean isEqualPosition(int otherPosition) {
        return this.position.equals(new Position(otherPosition));
    }
}
