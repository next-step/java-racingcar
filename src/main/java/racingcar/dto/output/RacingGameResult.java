package racingcar.dto.output;

import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

public class RacingGameResult {

    private final Name name;
    private final Position position;

    public RacingGameResult(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
