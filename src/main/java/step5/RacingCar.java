package step5;

import java.util.Objects;

public class RacingCar {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return status == racingCar.status && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status);
    }

    private final String name;
    private int status;

    public static RacingCar create(String name) {
        return new RacingCar(name);
    }

    public static RacingCar create(String name, int status) {
        return new RacingCar(name, status);
    }

    private RacingCar(String name) {
        this.name = name;
        this.status = 1;
    }

    private RacingCar(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public RacingCar move(Movable movable) {
        if (movable.move()) {
            this.status++;
        }
        return this;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

}
