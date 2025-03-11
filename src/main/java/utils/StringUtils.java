package utils;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("유틸 클래스는 인스턴스화할 수 없습니다.");
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
