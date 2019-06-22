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

    private static final int INIT_POSITION = 0;
    private int position;

    public Position() {
        this.position = INIT_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public int move() {
        return ++this.position;
    }
}
