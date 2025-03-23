package domain;

import movingStrategy.Moveable;

public class RacingCar {
    private final String name;
    private final Position position;

    public RacingCar(String name, Integer initialPosition) {
        this.name = name;
        this.position = new Position(initialPosition);
    }

    public void move(Moveable moveable) {
        if (moveable.isMoveable()) {
            this.position.add(1);
        }
    }

    public RacingCarCurrentStatus getCurrentStatus() {
        return new RacingCarCurrentStatus(this.name, this.position.copy());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        RacingCar rhs = (RacingCar) obj;
        return this.name.equals(rhs.name) && this.position.equals(rhs.position);
    }
}
