package edu.nextstep.racing.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 14:12
 */
public class Position {

    public static final Position INIT_POSITION = new Position(0);
    private static final int MOVE_POSITION = 1;
    private int position;

    public Position(int position) {
        positionValidation(position);
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public Position move() {
        return new Position(this.position + MOVE_POSITION);
    }

    private void positionValidation(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차 위치가 유효하지 않습니다.");
        }
    }
}
