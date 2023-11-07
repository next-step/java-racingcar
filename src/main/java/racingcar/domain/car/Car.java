package racingcar.domain.car;

import racingcar.domain.game.strategy.MoveStrategy;

public class Car {
    private static final int DEFAULT_MOVE_POSITION = 1;
    private static final int DEFAULT_CAR_NAME_LENGTH = 5;
    private final String name;
    private final Position position;

    public Car(String name) {
        validate(name);

        this.name = name;
        this.position = new Position();
    }

    public String getCarName() {
        return this.name;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position.move(DEFAULT_MOVE_POSITION);
        }
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }

        if (name.length() > DEFAULT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다. 초과된 자동차 : " + name);
        }
    }
}
