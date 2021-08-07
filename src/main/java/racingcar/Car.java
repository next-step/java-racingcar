package racingcar;

import java.util.Random;

public class Car {

    private int position;
    final static int MAX_RANDOM_NUMBER = 9;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            position++;
        }
    }

    // TODO car의 단위 테스트를 가능하도록 하면서 랜덤 값 주입할 발법 생각해보기.
    private int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER);
    }
}
