package step5;

import java.util.Objects;

public class RacingCar {

    private final Name name;
    private final Status status;

    public static RacingCar create(String name) {
        return new RacingCar(name);
    }

    public static RacingCar create(String name, int status) {
        return new RacingCar(name, status);
    }

    private RacingCar(String name) {
        this.name = new Name(name);
        this.status = new Status(1);
    }

    private RacingCar(String name, int status) {
        this.name = new Name(name);
        this.status = new Status(status);
    }

    public RacingCar move(Movable movable) {
        if (movable.move()) {
            status.increase();
        }
        return this;
    }

    public int getStatus() {
        return this.status.getStatus();
    }

    public boolean isWinner(int value) {
        return getStatus() == value;
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name) && Objects.equals(status, racingCar.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status);
    }
}
