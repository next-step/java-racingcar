package racingcar.domain.dto;

import racingcar.domain.Name;
import racingcar.domain.Position;

public class CarDto {
    private final Position position;
    private final Name name;

    public CarDto(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
