package racingcar.utils;

public class ParsingUtils {

    public static int parseStringToInt(String string) {
        int parsed = 0;

        try {
            parsed = Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("숫자로 파싱할 수 없는 입력값입니다.");
        }

        return parsed;
    }

}
