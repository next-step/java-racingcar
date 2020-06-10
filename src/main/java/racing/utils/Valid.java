package racing.utils;

import java.util.List;
import java.util.Optional;

public class Valid {

    private static int TIME_MIN_VALUE = 1;
    private static int POSITION_MIN_VALUE = 0;

    private Valid() {
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

    public static void positionMinusCheck(int position) {

        if (position < POSITION_MIN_VALUE) {
            throw new IllegalArgumentException("position은 음수가 될 수 없습니다.");
        }
    }

    public static void sizeCompare(String[] carNames, int[] positions) {
        if (positions == null) {
            throw new IllegalArgumentException("position이 null입니다.");
        }

        if (carNames == null) {
            throw new IllegalArgumentException("carName이 null입니다.");
        }

        if (carNames.length != positions.length) {
            throw new IllegalArgumentException("이름 사이즈와 위치 사이즈가 일치 하지 않습니다.");
        }
    }
}
