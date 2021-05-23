package racingCar;

import java.util.Random;

public class Stadium {
    public static int drawRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static Boolean isGreaterThanFour(int number) {
        return number >= 4;
    }

    public static void isMove(Car car, int number) {
        if (isGreaterThanFour(number)) {
            car.go();
        }
    }

    public void isRunning(Car car) {
        int number = drawRandomNumber();
        isMove(car, number);
    }
}
