package step3.util;

public class Validator {

    private final static String CAR_COUNT_ERROR = "자동차는 1대 이상이어야 합니다.";
    private final static String GAME_COUNT_ERROR = "게임 횟수는 1번 이상이어야 합니다.";

    public static void checkInput(int carCount, int gameCount) {

        if(carCount <= 0) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR);
        }

        if(gameCount <= 0) {
            throw new IllegalArgumentException(GAME_COUNT_ERROR);
        }
    }
}
