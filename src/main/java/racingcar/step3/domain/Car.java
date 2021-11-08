package racingcar.step3.domain;

import racingcar.step3.move.Moving;

import java.util.Random;

/**
 * Car(자동차) 클래스
 * 2021.11.04
 * 01.v
 */

public class Car {

    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 4;
    private int position;

    public Car() {
        this(1);
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }


    public void move(Moving moving) {
        if (moving.isMovable()) {
            this.position++;
        }
    }

    // 테스를 위한 메서드
    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    // 테스를 위한 메서드
    private boolean isMovable(int number) {
        return MIN_NUM <= number & number <= MAX_NUM;
    }

    // 테스를 위한 메서드
    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_NUM);
    }

}
