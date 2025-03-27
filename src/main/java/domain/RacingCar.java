package domain;

import movingStrategy.Moveable;

public class RacingCar {
    public static final int STEPS = 1;
    private final String name;
    private final Position position;

    public RacingCar(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public RacingCar(String name) {
        this(name, new Position(0));
    }

    public RacingCar move(Moveable moveable) {
        if (moveable.isMoveable()) {
            return new RacingCar(name, this.position.add(STEPS));
        }
        return this;
    }

    public RacingCarCurrentStatus getCurrentStatus() {
        return new RacingCarCurrentStatus(this.name, this.position.copy());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof RacingCar)) {
            return false;
        }

        RacingCar rhs = (RacingCar) obj;
        return this.name.equals(rhs.name) && this.position.equals(rhs.position);
    }

    @Override
    public int hashCode() {
        int result = this.name.hashCode();
        result = 31 * result + this.position.hashCode();
        return result;
    }
}
