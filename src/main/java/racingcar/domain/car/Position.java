package racingcar.domain.car;

import racingcar.exception.InvalidCarSettingException;

public class Position {
    private int position;
    private static final int FORWARD_DISTANCE = 1;
    private static final String INVALID_CAR_POSITION_MESSAGE = "자동차 위치는 음수값을 가질수 없습니다.";

    public Position(int position) {
        checkPositionValidation(position);
        this.position = position;
    }

    public void moveForward() {
        this.position += FORWARD_DISTANCE;
    }

    public int getPosition() {
        return position;
    }

    private void checkPositionValidation(int position) {
        if (position < 0) {
            throw new InvalidCarSettingException(INVALID_CAR_POSITION_MESSAGE);
        }
    }
}
