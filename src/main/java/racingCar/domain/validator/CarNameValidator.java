package racingCar.domain.validator;

public class CarNameValidator {
    public static final int MAX_NAME_LENGTH = 5;

    public static void validate(String name) {
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (!isValidLength(name)){
            throw new IllegalArgumentException(String.format("이름은 %d자를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }
    }

    private static boolean isValidLength(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }
}
