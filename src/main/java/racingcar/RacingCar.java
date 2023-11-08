package racingcar;

import java.util.Random;

public class RacingCar {

    public static final String CAR_COUNT_INPUT_MSG = "자동차 대수는 몇 대 인가요?";
    public static final String MOVE_COUNT_INPUT_MSG = "시도할 회수는 몇 회 인가요?";
    public static final int BOUND = 10;

    public static void main(String[] args) {
        int carCount = InputView.userInput(CAR_COUNT_INPUT_MSG);
        int moveCount = InputView.userInput(MOVE_COUNT_INPUT_MSG);
    }

    protected static int getRandom() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }

}
