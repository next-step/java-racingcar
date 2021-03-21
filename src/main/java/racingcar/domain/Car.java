/*
 * 자동차 경주의 자동차를 담당하는 클래스
 *
 * @author hj-woo
 * @version 2.0
 * */

package racingcar.domain;

import java.util.Random;

public class Car {
    private static final int INIT_NUM = 0;
    private static final int RANDOM_BOUND = 10;
    private static final int FORWARD_CONDITION = 4;
    private final Name name;
    private Position position;
    private final Random random;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
        this.random = new Random();
    }

    public Position getPosition() {
        return position;
    }

    public Name getName(){
        return name;
    }


    /*
     * 자동차가 전진하거나 멈추는 함수이며 0~9 사이의 random값에서 4이상일 경우 전진한다.
     * 전진시에는 전진한 횟수를 +1한다.
     * @param null
     * @return 자동차의 전진 여부, boolean
     * */
    public boolean move() {
        if (random.nextInt(RANDOM_BOUND) >= FORWARD_CONDITION) {
            position = position.move();
            return true;
        }
        return false;
    }

}

