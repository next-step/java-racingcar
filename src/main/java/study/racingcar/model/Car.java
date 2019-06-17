package study.racingcar.model;

import study.racingcar.condition.CarMoveCondition;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Car {
    private static final int DEFAULT_POSITION = 1; // 초기 위치

    private String name; // 자동차 이름
    private int position = DEFAULT_POSITION; // 이동한 거리

    public Car(String name) {
        this.name = name;
    }

    public void run() {
        if (this.canMove())
            position ++;
    }

    private boolean canMove() {
        return CarMoveCondition.canMove();
    }

    public int getPosition() {
        return position;
    }
}
