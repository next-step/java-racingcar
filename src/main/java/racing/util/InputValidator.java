package racing.util;

public class InputValidator {
    private static final int MAX_CAR_NAME_LETTERS = 5;

    public static String validateCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("입력한 값이 null 또는 공백일 수 없습니다.");
        }

        if (carName.length() > MAX_CAR_NAME_LETTERS) {
            throw new IllegalArgumentException("입력한 값이 5글자를 초과할 수 없습니다.");
        }

        return carName;
    }

    public static int validateCarPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("입력한 값이 0 미만 일 수 없습니다.");
        }

        return position;
    }

    public static int validateMatchCount(int matchCount) {
        if (matchCount < 0) {
            throw new IllegalArgumentException("입력한 값이 0 미만 일 수 없습니다.");
        }

        return matchCount;
    }
}
