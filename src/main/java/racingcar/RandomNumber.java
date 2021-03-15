package racingcar;

import java.util.Random;

public class RandomNumber {

    // TODO 이 둘은 난수 관련 클래스로 따로 만들어서 분리한다.
    static final int MINIMUM_NUMBER = 4;
    private static Random random = new Random();

    public static int random() {
        return random.nextInt(10);
    }
}
