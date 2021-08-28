package step3.util;

public class Validator {


    private static final String CAR_COUNT_ERROR = "자동차 이름은 한개 이상 입력 되어야 합니다.";
    private static final String GAME_COUNT_ERROR = "게임 횟수는 1번 이상이어야 합니다.";
    private static final String NAME_LENGTH_MIN_ERROR = "자동차 이름은 1자 이상이어야 합니다.";
    private static final String NAME_LENGTH_MAX_ERROR = "자동차 이름은 5자 이하여야 합니다.";
    private static final int MAX_NAME_LENGTH = 5;

    public void checkInput(String[] names, int gameCount) {
        checkNames(names);
        checkCount(gameCount, GAME_COUNT_ERROR);
    }

    private void checkNames(String[] names) {
        if (names == null || names.length == 0) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR);
        }

        checkCount(names.length, CAR_COUNT_ERROR);
        for(String name : names) {
            checkName(name);
        }
    }

    private void checkName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NAME_LENGTH_MIN_ERROR);
        }

        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_MAX_ERROR);
        }
    }

    private void checkCount(int count, String message) {
        if(count <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
