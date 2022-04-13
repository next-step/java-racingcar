package camp.nextstep.racingcar.domain;

import java.util.UUID;

public class Car {

    private final UUID id = UUID.randomUUID();
    private int distance;

    public void move(MoveCondition condition) {
        if (condition.isSatisfied()) {
            this.distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", distance=" + distance + '}';
    }
}
