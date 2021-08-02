package step4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCar{
    private final String name;
    private final List<String> status;
    private final Movable movable;

    public static RacingCar create(String name) {
        return new RacingCar(name);
    }

    public static RacingCar create(String name, Movable movable) {
        return new RacingCar(name, movable);
    }

    private RacingCar(String name) {
        this.name = name;
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

    private RacingCar(String name, Movable movable) {
        this.name = name;
        status = initializeStatus();
        this.movable = movable;
    }

    public void move() {
        if (movable.move()) {
            go(status);
        }
    }

    private void go(List<String> status) {
        status.add("-");
    }

    public List<String> getStatus() {
        return this.status;
    }

    public String getName() {
        return name;
    }

}
