package racingcar.step4.domain;

import racingcar.step4.domain.dto.ParticipantResultDto;
import racingcar.step4.domain.move.MoveStrategy;
import racingcar.step4.utils.ConstUtils;

public class Car {

    private final String name;
    private final MoveStrategy moveStrategy;
    private int location;

    public Car(String name, MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new IllegalArgumentException("이동 전략을 넣어주세요.");
        }

        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.isMove()) {
            location += ConstUtils.MOVE;
        }
    }

    public ParticipantResultDto getParticipantResult() {
        return new ParticipantResultDto(name, location);
    }
}
