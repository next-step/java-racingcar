package study.racingcar.model;

import study.racingcar.strategy.MovableStrategy;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Car {
    private static final int DEFAULT_POSITION = 1; // 초기 위치

    private MovableStrategy movableStrategy;
    private String name; // 자동차 이름
    private int position = DEFAULT_POSITION; // 이동한 거리

    public Car(MovableStrategy movableStrategy, String name) {
        this.movableStrategy = movableStrategy;
        this.name = name;
    }

    public int run() {
        if (this.canMove()) {
            position++;
        }

        return position;
    }

    private boolean canMove() {
        return movableStrategy.canMove();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
