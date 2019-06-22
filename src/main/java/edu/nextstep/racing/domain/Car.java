package edu.nextstep.racing.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 14:11
 */
public class Car {

    private static final int MOVE_POSSIBLE_NUMBER = 4;
    private CarName name;
    private Position position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public void carMove(int validNumber) {
        if(isMove(validNumber)) {
            this.position = new Position(position.move());
        }
    }

    public int getCarPosition() {
        return this.position.getPosition();
    }

    public String getCarName() {
        return this.name.getName();
    }

    private boolean isMove(int validNumber) {
        return validNumber >= MOVE_POSSIBLE_NUMBER ? true : false;
    }
}
