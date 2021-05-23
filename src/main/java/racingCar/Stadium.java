package racingCar;

import java.util.Random;

public class Stadium {
    public static int drawRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public Boolean isGreaterThanFour(int number) {
        return number >= 4;
    }
}
