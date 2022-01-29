package racingcar.domain;

import racingcar.controller.ResultDto;
import racingcar.domain.movable.MovableStrategy;

public class Car {

    private final PlayerName name;
    private int distance;

    public Car(final String name) {
        this.name = new PlayerName(name);
        this.distance = 0;
    }

    public PlayerName name() {
        return name;
    }

    public int distance() { return distance; }

    public boolean isDistance(final int distance) { return this.distance == distance; }

    public ResultDto run(final MovableStrategy strategy) {
        if (strategy.isMovable()) {
            this.distance++;
        }
        return new ResultDto(this);
    }
}
