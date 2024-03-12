package racingcar.step4.domain;

import racingcar.step4.domain.dto.ParticipantResultDto;
import racingcar.step4.domain.move.MoveStrategy;

public class Car {

    private final String name;
    private final MoveStrategy moveStrategy;
    private Location location;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.location = new Location(0);
    }

    public Car(String name, MoveStrategy moveStrategy, int location) {
        validateMoveStrategy(moveStrategy);

        this.name = name;
        this.moveStrategy = moveStrategy;
        this.location = new Location(location);
    }

    public void move() {
        if (moveStrategy.isMove()) {
            location = location.move();
        }
    }

    public ParticipantResultDto getParticipantResult() {
        return new ParticipantResultDto(name, location);
    }

    private static void validateMoveStrategy(MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new IllegalArgumentException("이동 전략을 넣어주세요.");
        }
    }
}
