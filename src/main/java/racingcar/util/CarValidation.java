package racingcar.util;

public class CarValidation {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public static void checkNameValidation(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5글자를 넘길 수 없습니다.");
        }
    }
}
