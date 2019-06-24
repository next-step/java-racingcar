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
        this(new CarName(name), Position.INIT_POSITION);
    }

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car carMove(int validNumber) {
        if (isMove(validNumber)) {
            return new Car(name, position.move());
        }
        return this;
    }

    public boolean comparePosition(int carPosition) {
        return position.getPosition() == carPosition;
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
