package domain;

public class RacingCar {
    public static final Position STEPS = new Position(1);
    private final String name;
    private final Position position;

    public RacingCar(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public RacingCar(String name) {
        this(name, Position.ZERO);
    }

    public RacingCar move() {
        return new RacingCar(name, this.position.add(STEPS));
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
