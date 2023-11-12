package study.validator;

public class NameValidator {

    private static final int AVAILABLE_COUNT = 5;

    public static boolean carsNameValidator(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("1글자 이상 입력이 필요합니다.");
        }
        if (input.length() > AVAILABLE_COUNT) {
            throw new IllegalArgumentException("5글자를 초과할 수 없습니다.");
        }
        return true;
    }
}
