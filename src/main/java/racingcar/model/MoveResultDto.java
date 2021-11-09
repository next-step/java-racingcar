package racingcar.model;

import racingcar.collection.CarName;
import racingcar.collection.Position;

public class MoveResultDto {
    private CarName carName;
    private Position position;

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
