package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Car {
    private final UUID id;
    private final List<Boolean> statuses = new ArrayList<>();

    public Car() {
        id = UUID.randomUUID();
    }

    public void moveCar(int count) {
        statuses.add(canMove(count));
    }

    private boolean canMove(int move) {
        return move >= 4;
    }

    public List<Boolean> getStatues() {
        return statuses;
    }
}
