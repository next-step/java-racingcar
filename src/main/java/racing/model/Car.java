package racing.model;

import racing.util.RandomUtil;

public class Car {

    private int position;

    public void move() {
        int randomNumber = RandomUtil.getRandomValue();

        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
