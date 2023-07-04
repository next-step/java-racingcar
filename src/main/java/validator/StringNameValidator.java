package validator;

public class StringNameValidator {

    private static final int MAX_NAME_LENGTH = 5;
    public static void validate(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }
}
