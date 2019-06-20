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

    private static final int MOVE_POSSIBLE_NUMBER = 4;

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

    public int move(int validMoveNumber) {
        return this.movePossible(validMoveNumber) ? ++this.moveIndex : this.moveIndex;
    }

    public int currentPosition() {
        return this.moveIndex;
    }

    public String getCarName() {
        return this.carName;
    }

    public boolean getCarNumber(int carNumber) {
        return this.carNumber == carNumber;
    }

    public boolean compareWinScore(Car car, int winScore) {
        return car.moveIndex >= winScore;
    }

    /*
    TEST코드 작성을 위해 접근제어자 default로 선언
     */

    boolean movePossible(int validMoveNumber) {
        return validMoveNumber >= MOVE_POSSIBLE_NUMBER;
    }
}
