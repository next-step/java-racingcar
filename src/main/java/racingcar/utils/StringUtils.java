package racingcar.utils;

public class StringUtils {

    public static String[] spliter(String stringWord) {
        if (stringWord == null || stringWord.trim().isEmpty()) {
            throw new NullPointerException("자동차 이름은 Null 또는 빈 값일 수 없습니다!");
        }

        return stringWord.split(",");
    }

    public static boolean isLengthWithinLimits(int start, int end, String word) {
        int length = word.length();
        return length >= start && length <= end;
    }
}
