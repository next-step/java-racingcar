package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final List<String> status;
    private final Movable movable;

    public static RacingCar create() {
        return new RacingCar();
    }

    public static RacingCar create(Movable movable) {
        return new RacingCar(movable);
    }

    private RacingCar() {
        status = initializeStatus();
        movable = setDefaultMovable();
    }

    private List<String> initializeStatus() {
        List<String> status = new ArrayList<>();
        status.add("-");
        return status;
    }

    private Movable setDefaultMovable() {
        return new RandomMovable();
    }

    private RacingCar(Movable movable) {
        status = initializeStatus();
        this.movable = movable;
    }

    public void move() {
        movable.move(status);
    }

    public List<String> getStatus() {
        return this.status;
    }

}
