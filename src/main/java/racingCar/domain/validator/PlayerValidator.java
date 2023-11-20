package racingCar.domain.validator;

public class PlayerValidator {
    public static final int MAX_NAME_LENGTH = 5;

    public static void validate(String name) {
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (!isValidLength(name)){
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        }
    }

    private static boolean isValidLength(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }
}
