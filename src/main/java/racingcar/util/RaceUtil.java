package racingcar.util;

public class RaceUtil {

    public static boolean determineCarMovement(int val) {
        if (val >= 0 && val <= 3) {
            return false;
        }

        if (val >= 4 && val <= 9) {
            return true;
        }

        throw new RuntimeException("범위 밖의 수가 입력되었습니다");
    }
}
