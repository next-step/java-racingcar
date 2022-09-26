package racingcar.util;

public class ConvertUtil {
    public static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("정수를 입력해주세요.");
        }
    }
}
