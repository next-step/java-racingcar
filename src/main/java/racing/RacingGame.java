package racing;

import java.util.Random;

public class RacingGame {
    private static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        int carCount = RacingGameInputView.getIntegerInput(GameMessage.CAR_COUNT_MESSAGE);
        int attemptCount = RacingGameInputView.getIntegerInput(GameMessage.ATTEMPT_COUNT_MESSAGE);

        Car testCar = new Car(2);
        RacingGameOutputView.printCarPosition(testCar);
    }

    public static int getRandomValue() {
        return new Random().nextInt(MAX_VALUE);
    }

}
