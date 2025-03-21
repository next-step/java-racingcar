package domain;

import movingStrategy.Moveable;

public class RacingCar {
    private final String name;
    private final Position position;
    private final Moveable moveable;

    public RacingCar(String name, Moveable moveable) {
        this.name = name;
        this.position = new Position(0);
        this.moveable = moveable;
    }

    public Integer position() {
        return this.position.position();
    }

    public void move() {
        if (moveable.isMoveable()) {
            this.position.add(1);
        }
    }

    public String name() {
        return this.name;
    }

    public RacingCarCurrentStatus getCurrentStatus() {
        return new RacingCarCurrentStatus(this.name, this.position.copy());
    }
}
