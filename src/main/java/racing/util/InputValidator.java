package racing.util;

public class InputValidator {
    public static void validateCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("입력한 값이 null 또는 공백일 수 없습니다.");
        }
    }
}
