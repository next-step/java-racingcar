package racing;

import java.util.Arrays;
import java.util.Random;

public class Car {

    private final int[] cars;

    public static final int MOVE_CONDITION = 4;
    public static final int MAX_RANDOM_NUMBER = 10;

    public Car(int carCount) {
        cars = new int[carCount];
        Arrays.fill(cars, 1);
    }

    private void moveCars() {
        for (int i = 0; i < cars.length; i++) {
            if (isMove(getRandomNumber())) {
                cars[i]++;
            }
        }
    }
    public void start(int retryCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < retryCount; i++) {
            ResultView.displayRace(cars);
            moveCars();
        }
    }

    public static int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER);
    }

    public static boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }
}
