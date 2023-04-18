package racing.util;

public class InputValidator {
    public static String validateCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("입력한 값이 null 또는 공백일 수 없습니다.");
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException("입력한 값이 5글자를 초과할 수 없습니다.");
        }

        return carName;
    }
}
