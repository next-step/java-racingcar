package racing.model;

import racing.util.RandomUtil;

public class Car {

    public static final int LEAST_NUM = 4;
    private int position;

    public void move() {
        int randomNumber = RandomUtil.getRandomValue();

        if (randomNumber >= LEAST_NUM) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
