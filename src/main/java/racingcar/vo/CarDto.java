package racingcar.vo;

import racingcar.domain.CarName;
import racingcar.domain.CarPosition;

public class CarDto {
    private final CarName carName;
    private final CarPosition position;

    public CarDto(final String name) {
        this(new CarName(name), new CarPosition(0));
    }

    public CarDto(final CarName name, final CarPosition position) {
        this.carName = name;
        this.position = position;
    }

    public CarName getCarName() {
        return this.carName;
    }

    public CarPosition getCarPosition() {
        return this.position;
    }
}
