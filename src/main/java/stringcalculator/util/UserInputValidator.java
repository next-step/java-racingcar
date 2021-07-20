package stringcalculator.util;

public class UserInputValidator {

    public static void validate(String str) {
        checkNullString(str);
        checkEmptyString(str);
    }

    private static void checkEmptyString(String str) {
        if (str.trim().isEmpty()) {
            throw new IllegalArgumentException("공백문자만으로는 연산을 수행할 수 없습니다.");
        }
    }

    private static void checkNullString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("유저로부터 입력이 전혀 없습니다.");
        }
    }

}
