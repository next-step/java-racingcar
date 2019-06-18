package edu.nextstep.raing.model;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-15 21:35
 */
public class Car {

    private int moveIndex;

    public Car() {
        this.moveIndex = 0;
    }

    public int move() {
        return ++this.moveIndex;
    }

    public int currentPosition() {
        return this.moveIndex;
    }
}
