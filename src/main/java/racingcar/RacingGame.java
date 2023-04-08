package racingcar;

import java.util.Random;

public class RacingGame {

    public static final int RUN_CONDITION = 4;
    public static final int RANDOM_RANGE = 10;
    private int[] cars;
    private int moveTimes;

    public void setCarNumber() {
        cars = new int[InputView.setCarNumber()];
    }

    public void setMoveTimes() {
        moveTimes = InputView.setMoveTimes();
    }

    public void racing() {
        System.out.println("실행결과");

        for (int i = 0; i < moveTimes; i++) {
            moveCars();
            ResultView.printResult(cars);
        }
    }

    private void moveCars() {
        for (int j = 0; j < cars.length; j++) {
            if (goOrStop(RUN_CONDITION, getRandomValue())) {
                cars[j] += 1;
            }
        }
    }

    public boolean goOrStop(int condition, int value) {
        return value >= condition ? true : false;
    }

    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }

    public int getCarNumber() {
        return cars.length;
    }

    public int getMoveTimes() {
        return moveTimes;
    }

}
