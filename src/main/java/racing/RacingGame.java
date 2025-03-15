package racing;

import java.util.Random;

public class RacingGame {
    public static final int MIN_VALUE = 0; // random 최소값
    public static final int MAX_VALUE = 9; // random 최대값

    public static final int MIN_MOVE_VALUE = 4; // 전진 최소값

    public static void main(String[] args) {
        int carCount = RacingGameInputView.getIntegerInput(GameMessage.CAR_COUNT_MESSAGE);
        int attemptCount = RacingGameInputView.getIntegerInput(GameMessage.ATTEMPT_COUNT_MESSAGE);

        Car testCar = new Car(2);
        RacingGameOutputView.printCarPosition(testCar);
    }

    public static int getRandomValue() {
        return new Random().nextInt(MAX_VALUE);
    }

    public static boolean isMovable(int input) {
        return input >= MIN_MOVE_VALUE;
    }

}
