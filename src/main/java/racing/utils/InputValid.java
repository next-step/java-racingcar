package racing.utils;

public class InputValid {

    private static int TIME_MIN_VALUE = 1;

    private InputValid() {
    }

    public static void isEmpty(String inputName) {
        if (isBlank(inputName)) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    private static boolean isBlank(String inputName) {
        return inputName == null || inputName.trim().isEmpty();
    }

    public static void timeGreaterThenZero(int inputTime) {

        if (inputTime < TIME_MIN_VALUE) {
            throw new IllegalArgumentException("반복횟수는 0보다 커야합니다.");
        }
    }

}
