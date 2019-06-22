package racingcar.domain;

import racingcar.domain.moving.MovingStrategy;
import racingcar.domain.moving.Position;

public class RacingCar implements Comparable<RacingCar>{
    private String name;
    private Position position;
    private MovingStrategy movingStrategy;

    private RacingCar(String name, Position position, MovingStrategy movingStrategy) {
        this.name = name;
        this.position = position;
        this.movingStrategy = movingStrategy;
    }

    public static RacingCar of(String name, Position position, MovingStrategy movingStrategy) {
        return new RacingCar(name, position, movingStrategy);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(position.get(), o.position.get());
    }
}