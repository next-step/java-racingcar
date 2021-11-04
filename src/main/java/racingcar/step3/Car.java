package racingcar.step3;

import java.util.Random;

/**
 * Car(자동차) 클래스
 * 2021.11.04
 * 01.v
 */

public class Car {

    private static final String SIGN = "-";
    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 4;
    private int id;
    private int position;

    public Car(int id) {
        this(id, 1);
    }

    public Car(int id, int position) {
        this.id = id;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    public void move() {
        int randomNum = getRandomNum();
        if (isMovable(randomNum)) {
            position++;
        }
    }

    private boolean isMovable(int number) {
        return MIN_NUM <= number & number <= MAX_NUM;
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_NUM);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(SIGN);
        }
        return builder.toString();
    }

}
