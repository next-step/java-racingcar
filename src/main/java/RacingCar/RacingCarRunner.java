package RacingCar;

import java.util.Random;

public class RacingCarRunner {
    public static int run() {
        Car car = new Car();

        int currentPosition = car.getCurrentPosition();

        if (isRunnable(getRandomNumber())) {
            currentPosition += 1;
            car.setCurrentPosition(currentPosition);
        }

        return currentPosition;
    }

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static boolean isRunnable(int num) {
        return (num >= 4);
    }
}
