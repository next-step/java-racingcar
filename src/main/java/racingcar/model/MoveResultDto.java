package racingcar.model;

import racingcar.collection.CarName;
import racingcar.collection.Position;

public class MoveResultDto {
    private final CarName carName;
    private final Position position;

    public MoveResultDto(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public CarName getCarName() {
        return carName;
    }

    public Integer getPosition() {
        return position.getPosition();
    }
}
