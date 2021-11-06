package racinggame;

public class InputValidator {
    public static void validate(String input) {
        validateZero(input);
        validateNullAndEmptySource(input);
        validateString(input);
    }

    private static void validateZero(String input) {
        if("0".equals(input)) {
            throw new IllegalArgumentException("입력값은 1이상으로 입력해주세요.");
        }
    }
    private static void validateNullAndEmptySource(String input) {
        if(("".equals(input)) || (input == null)) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private static void validateString(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("회수를 입력해주세요.");
        }
    }
}
