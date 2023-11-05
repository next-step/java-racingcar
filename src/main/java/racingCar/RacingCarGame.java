package racingCar;

import java.util.Random;

public class RacingCar {

    static final private int PIVOT_NUMBER_TO_FORWARD = 4;
    static final private int CLOSED_END_NUMBER_TO_GET_RANDOM_NUMBER_FROM_ZERO = 10;
    private final static String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private final static String GAME_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    void racing(){
        int carCount = new InputView(CAR_COUNT_QUESTION).input();
        int gameCount = new InputView(GAME_COUNT_QUESTION).input();
    }

    private boolean isSatisfiedForward(){
        return new Random().nextInt(CLOSED_END_NUMBER_TO_GET_RANDOM_NUMBER_FROM_ZERO) >= PIVOT_NUMBER_TO_FORWARD;
    }

}
