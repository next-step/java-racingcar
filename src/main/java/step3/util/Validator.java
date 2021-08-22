package step3.util;

public class Validator {


    private final String CAR_COUNT_ERROR = "자동차 이름은 한개 이상 입력 되어야 합니다.";
    private final String GAME_COUNT_ERROR = "게임 횟수는 1번 이상이어야 합니다.";
    private final String NAME_LENGTH_MIN_ERROR = "자동차 이름은 1자 이상이어야 합니다.";
    private final String NAME_LENGTH_MAX_ERROR = "자동차 이름은 5자 이하여야 합니다.";

    public void checkInput(String[] names, int gameCount) {
        checkName(names);
        checkCount(gameCount, GAME_COUNT_ERROR);
    }

    private void checkName(String[] names) {
        if (names == null || names.length == 0) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR);
        }

        checkCount(names.length, CAR_COUNT_ERROR);
        for(String name : names) {
            checkLength(name);
        }
    }

    private void checkLength(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NAME_LENGTH_MIN_ERROR);
        }

        if(name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_MAX_ERROR);
        }
    }

    private void checkCount(int count, String message) {
        if(count <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
