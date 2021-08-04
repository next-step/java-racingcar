package carracing.domain;

import java.util.Objects;

public class RacingCar {

    private Position position;
    private final CarName carName;

    public RacingCar(Position position, CarName carName) {
        this.position = position;
        this.carName = carName;
    }

    public static RacingCar of(Position initPosition, CarName carName) {
        return new RacingCar(initPosition, carName);
    }

    public Position getPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }

    public void move(MoveStrategy moveStrategy) {
        if (Objects.requireNonNull(moveStrategy).movable()) {
            position = position.next();
        }
    }
}
