package racinggame.view;

public class InputValidator {
    public static void validateCarNamesLengthInRange(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new RuntimeException("자동차 이름은 5자를 초과할 수 앖습니다.");
            }
        }
    }

    public static void validatePositive(String strValue) {
        if (!isNumber(strValue) || Integer.parseInt(strValue) <= 0) {
            throw new RuntimeException("시도할 횟수는 양수여야 합니다.");
        }
    }

    public static boolean isNumber(String strValue) {
        return strValue != null && strValue.matches("[-+]?\\d*\\.?\\d+");
    }
}
