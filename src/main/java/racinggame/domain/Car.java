package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final Integer MIN_MOVE_VALUE = 4;

    private Location location;
    private List<Boolean> record;

    public Car() {
        this.location = new Location();
        this.record = new ArrayList<>();
    }

    public void moveCar(int moveValue) {
        Boolean move = MIN_MOVE_VALUE <= moveValue;

        if (move) {
            location.moveLocation();
        }
        record.add(move);
    }

    public Location getLocation() {
        return location;
    }

    public long getRecord(int round) {
        return record.subList(0, round + 1).stream().filter(b -> b).count();
    }
}
