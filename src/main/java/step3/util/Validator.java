package step3.util;

public class Validator {

    private final String CAR_COUNT_ERROR = "자동차는 1대 이상이어야 합니다.";
    private final String GAME_COUNT_ERROR = "게임 횟수는 1번 이상이어야 합니다.";

    public void checkInput(int carCount, int gameCount) {
        checkCount(carCount, CAR_COUNT_ERROR);
        checkCount(gameCount, GAME_COUNT_ERROR);
    }

    private void checkCount(int count, String message) {
        if(count <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
