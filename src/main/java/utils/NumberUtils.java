package utils;

public class NumberUtils {

    private NumberUtils() {
        throw new IllegalStateException("유틸 클래스는 인스턴스화할 수 없습니다.");
    }

    public static boolean isNumber(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return false;
        }
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
