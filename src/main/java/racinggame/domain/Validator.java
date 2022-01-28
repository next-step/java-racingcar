package racinggame.domain;

import java.util.List;

public class Validator {

    public static final int MINIMUM_PLAYER = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String EMPTY_STRING = "";

    private Validator() {}

    public static void validatePossibleToStart(List<RacingCar> racingCars) {
        if (isPossibleToStart(racingCars)) {
            throw new IllegalArgumentException(
                    String.format("게임을 시작하려면 %d명 이상의 참가자가 필요합니다.", MINIMUM_PLAYER));
        }
    }

    private static boolean isPossibleToStart(List<RacingCar> racingCars) {
        return racingCars.size() < MINIMUM_PLAYER;
    }

    public static void validateNameLength(String carName) {
        if (carName.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름의 글자 수는 %d자 이하입니다.", MAXIMUM_NAME_LENGTH));
        }
    }

    public static void isNumber(String trial) {
        try {
            Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 숫자로 입력해주세요.");
        }
    }

    public static void checkIsBlank(String removedBlankInput) {
        if (removedBlankInput.equals(EMPTY_STRING)) {
            throw new IllegalArgumentException("값이 입력되지 않았습니다.");
        }
    }

    public static void checkNameIsBlank(String[] splitName) {
        for (String name : splitName) {
            if (name.equals(EMPTY_STRING)) {
                throw new IllegalArgumentException("RacingCar의 이름은 공백일 수 없습니다.");
            }
        }
    }
}
