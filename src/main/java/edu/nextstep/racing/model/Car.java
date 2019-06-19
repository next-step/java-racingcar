package edu.nextstep.racing.model;

import edu.nextstep.racing.utils.ValidationUtils;

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
    private int carNumber;
    private String carName;

    private static final int INIT_POSITION = 0;
    private static int autoIncrease = 0;

    public Car(String name) {
        ValidationUtils.checkObject(name);
        this.moveIndex = INIT_POSITION;
        this.carName = name;
        this.carNumber = autoIncrease++;
    }

    public int move() {
        return ++this.moveIndex;
    }

    public int currentPosition() {
        return this.moveIndex;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarNumber() {
        return this.carNumber;
    }
}
