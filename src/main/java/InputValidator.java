public class InputValidator {
    private InputValidator() {}

    public static void validateNullOrEmpty(String input) {
        if (isInputNull(input) || isInputEmpty(input)) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 문자열입니다.");
        }
    }

    private static boolean isInputNull(String input){
        return (input == null);
    }

    private static boolean isInputEmpty(String input){
        return (input.isEmpty());
    }

    public static boolean isOnlyNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void isPositive(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }

        int num = Integer.parseInt(input);

        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습ㄴ다.");
        }
    }
}
