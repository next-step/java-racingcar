package racingcar.step4.domain;

import racingcar.step4.domain.dto.ParticipantResultDto;
import racingcar.step4.domain.move.MoveStrategy;
import racingcar.step4.utils.ConstUtils;

public class Car {

    private final String name;
    private final MoveStrategy moveStrategy;
    private int location;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public ParticipantResultDto move() {
        location += getMoveDistance();
        return new ParticipantResultDto(name, location);
    }

    private int getMoveDistance() {
        if (isMove()) {
            return ConstUtils.MOVE;
        }

        return ConstUtils.STOP;
    }

    private boolean isMove() {
        return moveStrategy.move();
    }
}
