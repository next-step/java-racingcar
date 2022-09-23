 package racingcar.domain.validator;

public class NameValidator {
    private static final String NOT_VALID_MESSAGE = "은(는) 유효한 이름이 아닙니다.";
    private static final int MAX_LENGTH = 5;

    private NameValidator() {
    }

    public static void validate(String name) {
        if (isNotValid(name)) {
            throw new IllegalArgumentException(name + NOT_VALID_MESSAGE);
        }
    }

    public static boolean isNotValid(String name) {
        return isNullOrEmpty(name) || isOverLength(name);
    }

    private static boolean isOverLength(String name) {
        return name.strip().length() > MAX_LENGTH;
    }

    private static boolean isNullOrEmpty(String name) {
        return name == null || name.isEmpty();
    }

}
