package racingcar.backend.dto;

import racingcar.backend.domain.CarName;
import racingcar.backend.domain.Position;

public class CarDto {

    private final CarName carName;
    private final Position position;

    public CarDto(final CarName carName, final Position position) {
        this.carName = carName;
        this.position = position;
    }

    public static CarDto create(final CarName carName, final Position position) {
        return new CarDto(carName, position);
    }

    public Position getPosition() {
        return position;
    }

    public String printName() {
        return this.carName.gatValue();
    }

    public String printPosition(String mark) {
        return mark.repeat(position.gatValue());
    }
}
